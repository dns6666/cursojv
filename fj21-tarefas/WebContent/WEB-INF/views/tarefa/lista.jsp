<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Tarefas</title>
</head>
<body>
	<script type="text/javascript" >
	function finalizaAgora(id) {
		$.post("finalizaTarefa", {'id': id}, function() {
			$("#tarefa_"+id).html("Finalizado");
		});
	}
	</script>
	<a href="novaTarefa">Criar nova Tarefa</a>
	<table>
		<tr bgcolor="cyan">
			<th width="30px">Id</th>
			<th width="500px">Descrição</th>
			<th width="50px">Finalizado?</th>
			<th width="100px">Data de Finalização</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr bgcolor="yellow">
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
				<td align="center" id="tarefa_${tarefa.id}">
				<c:if test="${tarefa.finalizado eq true}">
			    	Sim</c:if>
			    <c:if test="${tarefa.finalizado eq false}">
					<a href="#" onclick="finalizaAgora(${tarefa.id})">Finaliza
							agora!</a>
				</c:if></td>
				<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="removeTarefa?id=${tarefa.id}">Remove</a></td>
				<td><a href="mostraTarefa?id=${tarefa.id}">Altera</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>