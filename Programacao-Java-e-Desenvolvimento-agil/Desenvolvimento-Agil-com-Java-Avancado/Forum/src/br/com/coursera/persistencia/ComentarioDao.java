package br.com.coursera.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.coursera.dominio.Comentario;

public class ComentarioDao implements IComendarioDao {
	
	private Conexao c;
	
	public ComentarioDao(Conexao conexao) {
		c = conexao;
	}

	@Override
	public int inserir(Comentario comentario) {
		int retorno = 0;
		try {
			String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?)";
			PreparedStatement stm = c.conectar().prepareStatement(sql);
			stm.setString(1, comentario.getComentario());
			stm.setString(2, comentario.getLogin());
			stm.setInt(3, comentario.getId_topico());
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
	public int inserir(String comentario, String login, int idTopico) {
		int retorno = 0;
		try {
			String sql = "INSERT INTO comentario(comentario, login, id_topico) VALUES (?, ?, ?)";
			PreparedStatement stm = c.conectar().prepareStatement(sql);
			stm.setString(1, comentario);
			stm.setString(2, login);
			stm.setInt(3, idTopico);
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
	public void registrarPontos(String usuario, int pontos) {
		try {
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement stm = c.conectar().prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, usuario);
			stm.executeUpdate();
			c.fechar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
	}

	@Override
	public List<Comentario> listarComentarios() {
		List<Comentario> comentarios = new ArrayList<>();
		try {
			String sql = "SELECT * FROM comentario";
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Comentario com = new Comentario(rs.getInt("id_topico"), 
						rs.getString("comentario"), 
						rs.getString("login"));
				comentarios.add(com);
			}
			c.fechar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return comentarios;
	}

	@Override
	public List<Comentario> listarComentariosDoTopico(int idTopico) {
		List<Comentario> comentarios = new ArrayList<>();
		try {
			String sql = "SELECT * FROM comentario WHERE id_topico = ?";
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			stmt.setInt(1, idTopico);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Comentario com = new Comentario(rs.getInt("id_topico"), 
						rs.getString("comentario"), 
						rs.getString("login"));
				comentarios.add(com);
			}
			c.fechar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return comentarios;
	}

	@Override
	public List<Comentario> listarComentariosDoUsuario(String login) {
		List<Comentario> comentarios = new ArrayList<>();
		try {
			String sql = "SELECT * FROM comentario WHERE login = ?";
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Comentario com = new Comentario(rs.getInt("id_topico"), 
						rs.getString("comentario"), 
						rs.getString("login"));
				comentarios.add(com);
			}
			c.fechar();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return comentarios;
	}

	@Override
	public int removerComentario(int idComentario) {
		// TODO Auto-generated method stub
		return 0;
	}

}
