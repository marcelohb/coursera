package br.com.coursera.persistencia;

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

public class UsuarioDaoTest {
	
	private UsuarioDao dao;
	private Conexao conexao;
	private JdbcDatabaseTester jd;
	private static String url = "jdbc:postgresql://192.168.99.100:9950/coursera";
	private static String driver = "org.postgresql.Driver";
	private static String user = "root";
	private static String pass = "vertrigo";
	
	@Before
	public void setUp() throws Exception {
		conexao = new Conexao();
		dao = new UsuarioDao(conexao);
		jd = new JdbcDatabaseTester(driver,url,user,pass);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jd.setDataSet(loader.load("/inicio.xml"));
		jd.onSetup();
	}

	@Test
	public void inserir() throws SQLException, Exception {
		Usuario u = new Usuario("patati", "patata", "patati@email.com", "Patati Patata", 0);
		assertEquals(1, dao.inserir(u));
		
		IDataSet currentDataSet = jd.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("usuario");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verificaUsuario.xml");
		ITable expectedTable = expectedDataSet.getTable("usuario");
		Assertion.assertEquals(expectedTable, currentTable);
	}
	
	@Test
	public void buscarPeloLogin() {
		Usuario u = dao.recuperar("eu");
		assertEquals("eu", u.getLogin());
		assertEquals("Eu Eu Mesmo", u.getNome());
		assertEquals(0, u.getPontos());
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
