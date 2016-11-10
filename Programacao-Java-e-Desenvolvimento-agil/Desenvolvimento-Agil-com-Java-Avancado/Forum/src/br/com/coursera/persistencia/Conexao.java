package br.com.coursera.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
//	private static String url = "jdbc:mysql://localhost/coursera";
	private static String url = "jdbc:mysql://192.168.99.100:32769/coursera";
	private static String user = "root";
	private static String pass = "vertrigo";
	
	static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public void conectar() {
		Connection c;
		try {
			c = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
