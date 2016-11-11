package br.com.coursera.persistencia;

import static org.junit.Assert.assertEquals;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.coursera.dominio.Topico;

public class TopicoDaoTest {
	
	private TopicoDao dao;
	private Conexao conexao;
	private JdbcDatabaseTester jd;
	private static String url = "jdbc:postgresql://192.168.99.100:9950/coursera";
	private static String driver = "org.postgresql.Driver";
	private static String user = "root";
	private static String pass = "vertrigo";
	
	@Before
	public void setUp() throws Exception {
		conexao = new Conexao();
		dao = new TopicoDao(conexao);
		jd = new JdbcDatabaseTester(driver,url,user,pass);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jd.setDataSet(loader.load("/inicio.xml"));
		jd.onSetup();
	}

	@Test
	public void inserirApenasTitulo() {
		Topico topico = new Topico("Tópico 1", "eu");
		assertEquals(1, dao.inserir(topico));
	}
	
	@Test
	public void inserirTopicoCompleto() {
		Topico topico = new Topico("Topico 2", "danilo");
		topico.setConteudo("Conteudo do topico 2");
		assertEquals(1, dao.inserir(topico));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inserirTopicoComUsuarioQueNaoExiste() {
		// TODO fazer um verificação antes se o usuario existe ou tratar a exception de FK
		// TODO criar exceção propria
	}

}
