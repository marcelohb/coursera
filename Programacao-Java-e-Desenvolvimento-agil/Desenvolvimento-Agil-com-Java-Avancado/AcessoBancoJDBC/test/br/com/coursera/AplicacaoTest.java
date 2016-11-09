package br.com.coursera;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.coursera.dominio.Usuario;
import br.com.coursera.persistencia.UsuarioDAO;

public class AplicacaoTest {
	
	private UsuarioDAO dao;
	private JdbcDatabaseTester jd;
	
	@Before
	public void setUp() throws Exception {
		jd = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/coursera","root","vertrigo");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jd.setDataSet(loader.load("/inicio.xml"));
		jd.onSetup();
		dao = new UsuarioDAO();
	}

	@Test
	public void recuperarPeloLogin() {
		Usuario usuario = dao.recuperar("eu");
		assertEquals("eu@email.com", usuario.getEmail());
		assertEquals("eu eu mesmo", usuario.getNome());
	}
	
	@Test
	public void inserirNovoUsuario() throws SQLException, Exception {
		Usuario patati = new Usuario("patati", "patata", "patati@email.com", "Patati Patata", 0);
		patati.setId(4);
		dao.inserir(patati);
		
		IDataSet currentDataSet = jd.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("usuario");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataSet.getTable("usuario");
		Assertion.assertEquals(expectedTable, currentTable);
	}

}
