package br.com.coursera.persistencia;

import java.sql.PreparedStatement;

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

}
