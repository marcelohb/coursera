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
	<form action="registrarLeitura" method="post">
		<c:forEach var="livro" items="${livros}">
			<li>
				<input type="checkbox" name="livrosLidos" ${livro.checked()} value="${livro.id}">
				 - <a href="exibeLivro?id=${livro.id}">${livro.titulo} - ${livro.estilo}</a>
			 </li>
		</c:forEach>
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>