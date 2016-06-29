package br.com.caelum.jdbc.teste;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaRemove {
	public static void main(String[] args) {
		try {
			Contato c = new Contato();
			c.setId((long) 28);
			ContatoDao dao = new ContatoDao();
			dao.remove(c);

			System.out.println("Removendo!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
