package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.modelo.Contato;
import br.com.caelum.jdbc.teste.ConnectionFactory;

public class ContatoDao {
	private Connection connection;

	public void adiciona(Contato contato) {
		String sql = "insert into contatos "
				+ "(nome,email,endereco,dataNascimento)" + "values(?,?,?,?)";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() throws SQLException {
		List<Contato> contatos = new ArrayList<>();
		PreparedStatement stmt = this.connection
				.prepareStatement("select * from contatos");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Contato c = new Contato();
			c.setId(rs.getLong("id"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			c.setEndereco(rs.getString("endereco"));

			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("dataNascimento"));
			c.setDataNascimento(data);

			contatos.add(c);
		}
		rs.close();
		stmt.close();
		return contatos;
	}

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
}
