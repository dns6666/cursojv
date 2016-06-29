package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;


public class AdicionarContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);

		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.adiciona(contato);
		
		System.out.println("Adicionando contato... ");
		return "mvc?logica=ListaContatosLogic";

	}

}
