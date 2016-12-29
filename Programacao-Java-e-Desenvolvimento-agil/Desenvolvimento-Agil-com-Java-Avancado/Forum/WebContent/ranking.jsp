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
	<h1>Ranking de Usuários</h1>
	<table>
		<tr>
			<td>-</td>
			<td>Nome</td>
			<td>Usuário</td>
			<td>Pontos</td>
		</tr>
		<c:forEach var="usuario" items="${usuarios}" varStatus="num">
			<tr>
				<td>${num.index+1}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
				<td>${usuario.pontos}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="listarTopicos">Voltar</a>
	<a href="logout">Sair</a>
</body>
</html>