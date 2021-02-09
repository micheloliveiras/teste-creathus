package br.com.creathus.teste.requests;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.creathus.teste.modelo.Pessoa;

public class CadastroPessoaRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@CPF
	private String cpf;
	
	@NotNull
	private LocalDate dataNascimento;

	public CadastroPessoaRequest(String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Pessoa toModel() {
		// TODO Auto-generated method stub
		return new Pessoa(nome, cpf, dataNascimento);
	}
	
	

}
