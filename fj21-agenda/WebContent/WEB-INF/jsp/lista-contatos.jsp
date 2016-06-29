<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="javax.servlet.descriptor.TaglibDescriptor, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<table>
		<thead>
			<tr bgcolor="cyan" style="font-family: arial;">
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
				<th></th>
				<th><a href="mvc?logica=MostraContatoLogic"> Adicionar</a></th>
			</tr>
		</thead>
		<tbody>
			<!-- percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${contatos}" varStatus="id">
				<tr bgcolor="${id.count % 2 == 0 ? 'lightyellow' : 'lightblue' }"
					style="font-family: Arial;">
					<td>${contato.nome}</td>
					<td><c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>E-mail não disponivel</c:otherwise>
						</c:choose></td>
					<td>${contato.endereco}</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}"
							pattern="dd/MMM/yyyy" /></td>
					<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}"
						title="Remover Contato ${contato.id}"> Remover</a></td>
					<td><a
						href="mvc?logica=MostraContatoLogic&id=${contato.id}"
						title="Alterar Contato ${contato.id}"> Alterar</a></td>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="rodape.jsp" />
</body>
</html>