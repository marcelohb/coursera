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
	
	static {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public void inserir(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario recuperar(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> usuarios = new ArrayList<>();
		Connection c;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost/cousera","root","vertrigo");
			
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			
			PreparedStatement stmt = c.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			System.out.println("Usuarios >>>>");
			while (rs.next()) {
				Usuario u = new Usuario(rs.getString("login"), 
						rs.getString("senha"), 
						rs.getString("email"), 
						rs.getString("nome"), 
						rs.getInt("pontos"));
				usuarios.add(u);
			}
			System.out.println("FIM");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

}
