package br.com.coursera.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.coursera.dominio.Usuario;

public class UsuarioDao implements IUsuarioDao {
	
	private Conexao c;
	
	public UsuarioDao(Conexao conexao) {
		c = conexao;
	}

	@Override
	public int inserir(Usuario usuario) {
		int retorno = 0;
		try {
			String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stm = c.conectar().prepareStatement(sql);
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getNome());
			stm.setString(4, usuario.getSenha());
			stm.setInt(5, usuario.getPontos());
			retorno = stm.executeUpdate();
			c.fechar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return retorno;
	}

	@Override
	public Usuario recuperar(String login) {
		Usuario u = null;
		try {
			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				u = new Usuario(rs.getString("login"), 
						rs.getString("senha"), 
						rs.getString("email"), 
						rs.getString("nome"), 
						rs.getInt("pontos"));
			}
			c.fechar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return u;
	}

	@Override
	public int adicionarPontos(String login, int pontos) {
		int retorno = 0;
		try {
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement stm = c.conectar().prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			retorno = stm.executeUpdate();
			c.fechar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return retorno;
	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario(rs.getString("login"), 
						rs.getString("senha"), 
						rs.getString("email"), 
						rs.getString("nome"), 
						rs.getInt("pontos"));
				usuarios.add(u);
			}
			c.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return usuarios;
	}

}
