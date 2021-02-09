package br.com.creathus.teste;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.creathus.teste.modelo.Pessoa;
import br.com.creathus.teste.repository.PessoaRepository;
import br.com.creathus.teste.requests.CadastroPessoaRequest;

@RestController
@RequestMapping("/pessoa")
public class PessoaResoures {
	
	
	@Autowired
	private PessoaRepository pr;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listaPessoas() {
		List<Pessoa> lista =this.pr.findAll();
		return ResponseEntity.ok().body(lista);
			
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> cadastro(@RequestBody CadastroPessoaRequest request) {
		Pessoa pes =request.toModel();
		this.pr.save(pes);
		return ResponseEntity.ok().body(pes);
		
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@RequestBody CadastroPessoaRequest request,@PathVariable("id") Long id) {
		Optional<Pessoa> optional = this.pr.findById(id);
		if (optional.isPresent()) {
			Pessoa pe =optional.get();
			pe.setNome(request.getNome());
			pe.setCpf(request.getCpf());
			pe.setDataNascimento(request.getDataNascimento());
			this.pr.save(pe);
			
			return ResponseEntity.ok().body(pe);
		}
		return ResponseEntity.badRequest().build();	
	}
	
	@DeleteMapping("/{id}")
	public Pessoa deletar(@PathVariable("id") Long id) {
		Optional<Pessoa> optional = this.pr.findById(id);
		if (optional.isPresent()) {
			Pessoa pe =optional.get();
			this.pr.delete(pe);
		}
		return null;
		
	}
	
	
}
