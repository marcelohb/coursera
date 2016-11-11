package br.com.coursera.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
	
	private Connection c;
	// LOCALHOST
//	private static String url = "jdbc:postgresql://localhost/coursera";
	// DOCKER
	private static String url = "jdbc:postgresql://192.168.99.100:9950/coursera";
	private Properties props;
	
	static {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public Connection conectar() {
		props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("password", "vertrigo");
		try {
			return c = DriverManager.getConnection(url,props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void fechar() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
