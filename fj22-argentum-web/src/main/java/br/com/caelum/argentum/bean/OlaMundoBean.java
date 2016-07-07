package br.com.caelum.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	private String mensagem = "Quem é você?";
	private String nome;
	
	public String getMensagem(){
		System.out.println("getMensagem");
		return mensagem;
	}

	public String getNome() {
		System.out.println("getNome");
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		System.out.println("setNome");
	}
	
	public void nomeFoiDigitado(){
		System.out.println("\nChamou o botão");
	}
}
