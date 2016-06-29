<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista contatos</title>
</head>
<body>
	<table border="true">
		<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
		%>
		<thead>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
				for (Contato contato : contatos) {
			%>
			<tr>
				<td align="justify"><%=contato.getNome()%></td>
				<td><%=contato.getEmail()%></td>
				<td><%=contato.getEndereco()%></td>
				<td><%=sdf.format(contato.getDataNascimento().getTime())%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>