package br.com.coursera.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import br.com.coursera.dominio.Topico;

public class TopicoDao implements ITopicoDao {
	
	private Conexao c;

	public TopicoDao(Conexao conexao) {
		c = conexao;
	}

	@Override
	public int inserir(Topico topico) {
		int retorno = 0;
		try {
			String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?)";
			PreparedStatement stm = c.conectar().prepareStatement(sql);
			stm.setString(1, topico.getTitulo());
			stm.setString(2, topico.getConteudo());
			stm.setString(3, topico.getLogin());
			retorno = stm.executeUpdate();
		} catch (PSQLException psqlE) {
			if (psqlE.getMessage().contains("topico_login_fkey")) 
				throw new IllegalArgumentException("Usuario nao encontrado");
			throw new IllegalArgumentException("Problemas com a base de dados. " + psqlE.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return retorno;
	}

	@Override
	public int inserir(String titulo, String usuario) {
		Topico t = new Topico(titulo, usuario);
		return this.inserir(t);
	}

	@Override
	public void registrarPontos(String login) {
		UsuarioDao daoUsuario = new UsuarioDao(c);
		daoUsuario.adicionarPontos(login, 10);
	}

	@Override
	public List<Topico> listarTopicos() {
		List<Topico> topicos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM topico";
			
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Topico t = new Topico(rs.getString("titulo"), rs.getString("login"));
				t.setId(rs.getInt("id_topico"));
				t.setConteudo(rs.getString("conteudo"));
				topicos.add(t);
			}
			c.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return topicos;
	}

	@Override
	public List<Topico> listarTopicosDoUsuario(String login) {
		List<Topico> topicos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM topico WHERE login = ?";
			
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Topico t = new Topico(rs.getString("titulo"), rs.getString("login"));
				t.setId(rs.getInt("id_topico"));
				t.setConteudo(rs.getString("conteudo"));
				topicos.add(t);
			}
			c.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return topicos;
	}

	@Override
	public int removerTopico(int idTopico) {
		int retorno = 0;
		try {
			String sql = "DELETE FROM topico WHERE id_topico = ?";
			
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			stmt.setInt(1, idTopico);
			retorno = stmt.executeUpdate();
			c.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return retorno;
	}

	@Override
	public Topico buscarTopicoPorId(int id) {
		Topico topico = null;
		try {
			String sql = "SELECT * FROM topico WHERE id_topico = ?";
			
			PreparedStatement stmt = c.conectar().prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				topico = new Topico(rs.getString("titulo"), rs.getString("login"));
				topico.setId(rs.getInt("id_topico"));
				topico.setConteudo(rs.getString("conteudo"));
			}
			c.fechar();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fechar();
		}
		return topico;
	}

}
