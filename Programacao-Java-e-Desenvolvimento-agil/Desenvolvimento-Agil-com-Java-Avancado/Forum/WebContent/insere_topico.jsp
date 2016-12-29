<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum do Marcelo</title>
</head>
<body>
	<p>${mensagem}</p>
	<p>Inserir novo tópico</p>
	<form action="insereTopico" method="post">
		<label for="">Titulo</label>
		<input type="text" name="titulo" id="titulo" />
		<label for="">Texto</label>
		<input type="text" name="conteudo" id="conteudo" />
		<label for="">Usuário</label>
		<input type="text" name="usuario" id="usuario" disabled="disabled" value="${usuario.getLogin()}" />
		<input type="submit" value="Cadastrar">
	</form>
	<a href="logout">Sair</a>
</body>
</html>