<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Ola ${usuario.getNome()}</p>
	<ul>
		<li><a href="livros.jsp">Livros</a></li>
		<li><a href="leitores.jsp">Leitores</a></li>
		<li><a href="ranking.jsp">Ranking</a></li>
	</ul>
</body>
</html>