<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<title>Adiciona Contatos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/cabecalho.jsp"></c:import>
	<h1>Adiciona Contatos</h1>
	<form action="mvc" method="post">
		<input type="hidden" name="logica" value="AdicionarContatoLogic"/>
		Nome: <input type="text" name="nome" width="100px" /><br/> <br>
		E-mail: <input type="text" name="email" /><br/> <br> 
		Endereço: <input type="text" name="endereco" /><br/> <br>
		Data Nascimento: <caelum:campoData id="dataNascimento" /><br/> <br>
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="/WEB-INF/jsp/rodape.jsp"></c:import>
</body>
</html>