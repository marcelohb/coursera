package br.com.coursera.persistencia;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.dataset.CompositeTable;
import org.dbunit.dataset.FilteredTableMetaData;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import br.com.coursera.AbstractTest;
import br.com.coursera.dominio.Comentario;

public class ComentarioDaoTest extends AbstractTest {
	
	private ComentarioDao dao;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		dao = new ComentarioDao(conexao);
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jd.setDataSet(loader.load("/inicioTopico.xml"));
		jd.onSetup();
	}

	@Test
	public void inserirComentarioERegistrarPonto() throws SQLException, Exception {
		Comentario comentario = new Comentario(1, "Comentario 1", "eu");
		assertEquals(1, dao.inserir(comentario));
		dao.registrarPontos("eu", 3);
		
		DefaultColumnFilter columnExcluded = new DefaultColumnFilter();
		columnExcluded.excludeColumn("ID_*");
		
		IDataSet currentDataSet = jd.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("comentario");
		ITable usuarioDoBanco = currentDataSet.getTable("usuario");
		FilteredTableMetaData meta = new FilteredTableMetaData(currentTable.getTableMetaData(), columnExcluded);
		ITable filtered = new CompositeTable(meta, currentTable);
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = loader.load("/verificaComentario.xml");
		ITable expectedTable = expectedDataSet.getTable("comentario");
		ITable usuarioEsperado = expectedDataSet.getTable("usuario");
		Assertion.assertEquals(expectedTable, filtered);
		Assertion.assertEquals(usuarioEsperado, usuarioDoBanco);
	}
	
	@Test
	public void listarComentarios() {
		Comentario comentario = new Comentario(1, "Comentario 1", "eu");
		assertEquals(1, dao.inserir(comentario));
		
		List<Comentario> comentarios = dao.listarComentarios();
		assertEquals(1, comentarios.size());
	}
	
	@Test
	public void filtrarComentariosDeUmUsuario() {
		Comentario comentario = new Comentario(1, "Comentario 1", "eu");
		Comentario comentario1 = new Comentario(1, "Segundo", "eu");
		Comentario comentario2 = new Comentario(1, "Três", "danilo");
		assertEquals(1, dao.inserir(comentario));
		assertEquals(1, dao.inserir(comentario1));
		assertEquals(1, dao.inserir(comentario2));
		
		List<Comentario> comentariosEu = dao.listarComentariosDoUsuario("eu");
		List<Comentario> comentariosDanilo = dao.listarComentariosDoUsuario("danilo");
		assertEquals(2, comentariosEu.size());
		assertEquals(1, comentariosDanilo.size());
	}

}
