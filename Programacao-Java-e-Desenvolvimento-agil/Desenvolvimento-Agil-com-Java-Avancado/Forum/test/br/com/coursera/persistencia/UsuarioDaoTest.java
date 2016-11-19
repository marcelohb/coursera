package br.com.coursera.persistencia;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.coursera.AbstractTest;
import br.com.coursera.dominio.Usuario;

public class UsuarioDaoTest extends AbstractTest {
	
	private UsuarioDao dao;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		dao = new UsuarioDao(conexao);
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
	
	@Test
	public void verificaRanking() throws SQLException, Exception {
		dao.adicionarPontos("eu", 20);
		dao.adicionarPontos("danilo", 1);
		dao.adicionarPontos("jonh", 99);
		List<Usuario> ranking = dao.ranking();
		
		assertEquals("jonh", ranking.get(0).getLogin());
		assertEquals("eu", ranking.get(1).getLogin());
		assertEquals("danilo", ranking.get(2).getLogin());
	}
	
	@Test
	public void autenticar() {
		Usuario u = dao.autenticar("eu","*****");
		if (u==null)
			System.out.println("nulo");
		assertEquals("Eu Eu Mesmo", u.getNome());
	}

}
