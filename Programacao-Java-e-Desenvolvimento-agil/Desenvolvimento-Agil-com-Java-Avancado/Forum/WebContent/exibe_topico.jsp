<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forum do Marcelo</title>
</head>
<body>
	<p>Tópico ${topico.id}</p>
	<h1>Título: ${topico.titulo}</h1>
	<p>Conteúdo: ${topico.conteudo}</p>
	<h6>Usuário: ${topico.login}</h6>
	<h3>Comentários:</h3>
	<c:forEach var="comentario" items="${comentarios}">
		<li>${comentario.comentario} - ${comentario.login}</li>
	</c:forEach>
	<hr>
	<form action="novoComentario" method="post">
		<label for="novoComentario">Comentário</label>
		<input type="text" name="novoComentario" id="novoComentario">
		<input type="hidden" value="${topico.id}" name="idTopico">
		<input type="submit" value="Salvar">
	</form>
	<a href="listarTopicos">Voltar</a>
	<a href="logout">Sair</a>
</body>
</html>