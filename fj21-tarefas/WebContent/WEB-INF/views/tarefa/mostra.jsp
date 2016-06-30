<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Altera Tarefa</title>
</head>
<body>
	<h3>Altera Tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="post">
		<input type="hidden" value="${tarefa.id}" name="id" /><br />
		Descrição:<br />
		<textarea cols="50" rows="5" name="descricao">
			${tarefa.descricao}
		</textarea><br />
		Finalizado?<input type="checkbox" name="finalizado"
			value="true" ${tarefa.finalizado?"checked":""} /><br />
		<fmt:formatDate value="${tarefa.dataFinalizacao.time}" var="date" />
		Data finalização: <input type="text" value="${date}"
			name="dataFinalizacao" /><br /> <input type="submit" value="Alterar" />
	</form>
</body>
</html>