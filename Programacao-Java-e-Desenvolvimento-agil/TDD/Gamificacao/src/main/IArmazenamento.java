package main;

import java.util.HashMap;
import java.util.List;

public interface IArmazenamento {
	
	public void armazenar(String usuario, int quantidade, Pontos tipo);
	
	public int recuperarPontosUsuarioPorTipo(Usuario usuario, Pontos tipo);
	
	public HashMap<Pontos, Integer> recuperarTiposDePontosDeUmUsuario(String usuario);
	
	public List<Usuario> recuperarUsuarios();

}
