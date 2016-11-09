package br.com.coursera;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

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

//	private static String url = "jdbc:mysql://localhost/coursera";
	private static String url = "jdbc:mysql://192.168.99.100:32769/coursera";
	private static String user = "root";
	private static String pass = "vertrigo";
	
	@Before
	public void setUp() throws Exception {
		jd = new JdbcDatabaseTester("com.mysql.jdbc.Driver",url,user,pass);
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
	
	@Test
	public void verificaRanking() throws SQLException, Exception {

		List<Usuario> ranking = dao.ranking();
		
		assertEquals("jonh", ranking.get(0).getLogin());
		assertEquals("eu", ranking.get(1).getLogin());
		assertEquals("danilo", ranking.get(2).getLogin());
	}
	
	@Test
	public void adicionarPontos() throws SQLException, Exception {
		dao.adicionarPontos("eu", 10);
		
		IDataSet currentDataSet = jd.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("usuario");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verificaPontos.xml");
		ITable expectedTable = expectedDataSet.getTable("usuario");
		Assertion.assertEquals(expectedTable, currentTable);
	}

}
