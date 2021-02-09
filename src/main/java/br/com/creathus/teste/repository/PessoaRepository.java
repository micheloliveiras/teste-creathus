package br.com.creathus.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.creathus.teste.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
