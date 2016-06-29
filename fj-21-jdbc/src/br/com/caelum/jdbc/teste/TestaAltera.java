package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {
	public static void main(String[] args) {
		Contato c = new Contato();
		c.setId((long) 29);
		c.setNome("Gisele");
		c.setEmail("gisele@teste.tst");
		c.setEndereco("Rua dos testes, 12345");
		c.setDataNascimento(Calendar.getInstance());
		ContatoDao dao = new ContatoDao();
		dao.altera(c);
		
		System.out.println("Alterando!");
	}
}
