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
	<p>Ola ${usuario.getNome()}</p>
	<a href="insere_topico.jsp">Novo Tópico</a><br>
	<a href="ranking">Ranking</a><br>
	<h1>Tópicos</h1>
	<c:forEach var="topico" items="${topicos}">
		<li><a href="exibeTopico?id=${topico.id}">${topico.titulo} - ${topico.login}</a></li>
	</c:forEach>
	<a href="logout">Sair</a>
</body>
</html>