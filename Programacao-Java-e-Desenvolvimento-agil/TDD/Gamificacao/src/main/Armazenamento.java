package main;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Armazenamento implements IArmazenamento {
	
	private Path arquivo;
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Armazenamento(String caminho) {
		arquivo = Paths.get(caminho);
	}

	public void armazenar(String usuario, int quantidade, Pontos tipo) {
		Usuario us = new Usuario(usuario);
		if (usuarios.contains(us))
			us = usuarios.get(usuarios.indexOf(us));

		us.somarPontuacao(tipo, quantidade);
		if (usuarios.contains(us)) {
			usuarios.set(usuarios.indexOf(us), us);
		} else {
			usuarios.add(us);
		}
		salvarEmArquivo();
	}

	public int recuperarPontosUsuarioPorTipo(Usuario usuario, Pontos tipo) {
		int indice = usuarios.indexOf(usuario);
		HashMap<Pontos, Integer> qtd = usuarios.get(indice).obterPontuacao();
		return qtd.get(tipo);
	}

	public HashMap<Pontos, Integer> recuperarTiposDePontosDeUmUsuario(String usuario) {
		Usuario u = new Usuario(usuario);
		return usuarios.get(usuarios.indexOf(u)).obterPontuacao();
	}

	public List<Usuario> recuperarUsuarios() {
		return usuarios;
	}
	
	private void salvarEmArquivo() {
		BufferedWriter escrever = null;
		try {
			escrever = Files.newBufferedWriter(arquivo);
			JSONObject o = new JSONObject();
			JSONArray obj = new JSONArray();
			for (Usuario u : usuarios) {
				obj.add(u);
			}
			o.put("usuario", obj);
			escrever.write(o.toJSONString());
			escrever.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Usuario parseUsuario(String usuarioString) {
		Usuario u = null;
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(usuarioString);
			JSONObject jsonObj = (JSONObject) obj;
			String nome = (String) jsonObj.get("nome");
			JSONArray pontos = (JSONArray) jsonObj.get("pontos");
			
			u = new Usuario(nome);
			Iterator<String> it = pontos.iterator();
			while(it.hasNext()) {
				String[] p = it.next().split(":");
				u.obterPontuacao().put(Pontos.valueOf(p[0].trim()), Integer.valueOf(p[1].trim()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	private List<Usuario> lerDeArquivo() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("src/gamificacao.txt"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray usuariosDoArquivo = (JSONArray) jsonObject.get("usuario");
			Iterator<JSONObject> it = usuariosDoArquivo.iterator();
			while(it.hasNext()) {
				Usuario u = parseUsuario(it.next().toString());
				usuarios.add(u);
			}
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public List<Usuario> ler() {
		// TODO alterar acesso para private ou transferir para MOCK de armazenamento
//		Usuario u = null;
//		String JSON = "{\"pontos\":[\"CURTIDA : 10\",\"MOEDA : 10\"],\"nome\":\"GUERRA\"}";
//		try {
//			JSONParser parser = new JSONParser();
//			Object obj = parser.parse(JSON);
//			JSONObject jsonObj = (JSONObject) obj;
//			String nome = (String) jsonObj.get("nome");
//			JSONArray pontos = (JSONArray) jsonObj.get("pontos");
//			
//			u = new Usuario(nome);
//			Iterator<String> it = pontos.iterator();
//			while(it.hasNext()) {
//				String[] p = it.next().split(":");
//				u.obterPontuacao().put(Pontos.valueOf(p[0].trim()), Integer.valueOf(p[1].trim()));
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		return u;
//		return lerDeArquivo();
//		usuarios.get(0);
//	}

//	public boolean lerArquivo() { // TODO alterar para private
//		
//		if (arquivo.toFile().exists())
//			return true;
//		
//		try {
//			return arquivo.toFile().createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

}
