<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<td>${tarefa.id}</td>
	<td>${tarefa.descricao}</td>
	<td>Sim</td>
	<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/></td>
	<td><a href="#" onclick="removeAgora(${tarefa.id}, tarefa_${tarefa.id})">Remove</a></td>
	<td><a href="mostraTarefa?id=${tarefa.id}">Altera</a></td>
