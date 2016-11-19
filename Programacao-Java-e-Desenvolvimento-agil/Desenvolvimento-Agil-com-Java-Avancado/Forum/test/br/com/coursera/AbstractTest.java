package br.com.coursera;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;

import br.com.coursera.persistencia.Conexao;

public class AbstractTest {
	
	protected Conexao conexao;
	protected JdbcDatabaseTester jd;
	private static String url = Conexao.url;
	private static String driver = "org.postgresql.Driver";
	private static String user = "root";
	private static String pass = "vertrigo";
	
	@Before
	public void setUp() throws Exception {
		conexao = new Conexao();
		jd = new JdbcDatabaseTester(driver,url,user,pass);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jd.setDataSet(loader.load("/inicio.xml"));
		jd.onSetup();
	}

}
