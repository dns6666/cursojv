package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@SuppressWarnings("serial")
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(request
					.getParameter("dataNascimento"));
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);

		RequestDispatcher rd = request
				.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);

	}
}
