package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));

		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);

		contato.setDataNascimento(dataNascimento);

		Connection connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.atualiza(contato);

		System.out.println("Alterando contato... ");
		return "mvc?logica=ListaContatosLogic";
	}

}
