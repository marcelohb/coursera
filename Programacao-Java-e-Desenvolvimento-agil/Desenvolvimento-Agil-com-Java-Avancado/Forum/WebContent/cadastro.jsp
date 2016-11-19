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
	<form action="cadastro" method="post">
		<label for="">Nome</label>
		<input type="text" name="nome" id="nome" />
		<label for="">E-mail</label>
		<input type="text" name="email" id="email" />
		<label for="">Usuário</label>
		<input type="text" name="usuario" id="usuario" />
		<label for="">Senha</label>
		<input type="password" name="senha" id="senha" />
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>