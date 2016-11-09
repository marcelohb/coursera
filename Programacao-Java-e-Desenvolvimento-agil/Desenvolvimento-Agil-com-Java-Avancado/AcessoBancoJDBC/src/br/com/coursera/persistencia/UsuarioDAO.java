package br.com.coursera.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.coursera.dominio.Usuario;

public class UsuarioDAO implements IUsuarioDAO {
	
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

	@Override
	public void inserir(Usuario usuario) {
		Connection c;
		try {
			c = DriverManager.getConnection(url,user,pass);
			String sql = "INSERT INTO usuario(login, email, nome, senha, pontos, id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getNome());
			stm.setString(4, usuario.getSenha());
			stm.setInt(5, usuario.getPontos());
			stm.setInt(6, usuario.getId());
			stm.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario recuperar(String login) {
		Connection c;
		Usuario u = null;
		try {
			c = DriverManager.getConnection(url,user,pass);
			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				u = new Usuario(rs.getString("login"), 
						rs.getString("senha"), 
						rs.getString("email"), 
						rs.getString("nome"), 
						rs.getInt("pontos"));
			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		Connection c;
		try {
			c = DriverManager.getConnection(url,user,pass);
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			stm.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> usuarios = new ArrayList<>();
		Connection c;
		try {
			c = DriverManager.getConnection(url,user,pass);
			
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario(rs.getString("login"), 
						rs.getString("senha"), 
						rs.getString("email"), 
						rs.getString("nome"), 
						rs.getInt("pontos"));
				usuarios.add(u);
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
