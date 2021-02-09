package br.com.creathus.teste.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoas")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@CPF
	private String cpf;
	
	@NotNull
	private LocalDate dataNascimento;
	
	public Pessoa(@NotBlank String nome, @NotBlank @CPF String cpf, @NotNull LocalDate dataNascimento) {
		// TODO Auto-generated constructor stub
		this.nome =nome;
		this.cpf =cpf;
		this.dataNascimento =dataNascimento; 
	

		
	}
    public Pessoa() {}

	public Long getId() {
		return id;
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
 
	
	

}
