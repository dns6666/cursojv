package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class MostraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		if (req.getParameter("id") == null) {
			return "/WEB-INF/jsp/adiciona-contato.jsp";
		} else {
			long id = Long.parseLong(req.getParameter("id"));

			Connection connection = (Connection) req.getAttribute("conexao");

			Contato contato = new ContatoDao(connection).listaContato(id);
			req.setAttribute("contato", contato);

			return "/WEB-INF/jsp/altera-contato.jsp";

		}

	}

}
