<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/jquery.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Altera Contato</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/cabecalho.jsp"></c:import>
	<h1>Altera Contatos</h1>
	<form action="mvc">
		<input type="hidden" name="logica" value="AlteraContatoLogic"/>
		<input type="hidden" name="id" value="${contato.id}"/>
		Nome: <input value="${contato.nome}" type="text" name="nome" width="100px" /><br/> <br>
		E-mail: <input value="${contato.email}" type="text" name="email" /><br/> <br>
		Endereço: <input value="${contato.endereco}" type="text" name="endereco" /><br/> <br>
		<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="data"/><br/>
		Data Nascimento:  <input type="text" name="dataNascimento" value="${data}"/>
		<input type="submit" value="Gravar" />
	</form>
	<c:import url="/WEB-INF/jsp/rodape.jsp"></c:import>
</body>
</html>