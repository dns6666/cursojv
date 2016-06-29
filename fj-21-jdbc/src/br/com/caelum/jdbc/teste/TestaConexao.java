package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão Aberta!");
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
