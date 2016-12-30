<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leitura de Livros</title>
</head>
<body>
	<form action="login" method="post">
		<p>${mensagem}</p>
		<label for="usuario">Usuario</label>
		<input type="text" name="usuario" />
		<label for="senha">Senha</label>
		<input type="password" name="senha" />
		<input type="submit" value="Logar">
	</form>
</body>
</html>