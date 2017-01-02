<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leitura de Livros</title>
</head>
<body>
	<p>Ola ${usuario.getNome()}</p>
	<h1>Livros</h1>
	<p><a href="menu.jsp">Menu</a></p>
	<c:forEach var="livro" items="${livros}">
		<li>
			 - <a href="exibeLivro?id=${livro.id}">${livro.titulo} - ${livro.estilo}</a>
		 </li>
	</c:forEach>
</body>
</html>