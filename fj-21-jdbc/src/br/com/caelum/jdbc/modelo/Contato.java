package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

public class Contato {
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @return the dataNascimento
	 */
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
