package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {
	public static void main(String[] args) throws SQLException {
		Contato contato = new Contato();
		contato.setNome("Daniel");
		contato.setEmail("daniel@teste.com");
		contato.setEndereco("Rua Testes, 123 cj 456");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravando!");
	}
}
