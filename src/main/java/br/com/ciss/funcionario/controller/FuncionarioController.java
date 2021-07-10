package br.com.ciss.funcionario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ciss.funcionario.model.Funcionario;
import br.com.ciss.funcionario.service.FuncionarioService;

@RestController
@RequestMapping({ "/api/funcionarios" })
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioService.findAll();
	}

	@PostMapping
	public Funcionario adicionar(@RequestBody @Valid Funcionario funcionario) {
		return funcionarioService.save(funcionario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> editar(@PathVariable("id") Long id, @RequestBody Funcionario funcionario) {
		return funcionarioService.update(id, funcionario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") long id) {
		return funcionarioService.delete(id);
	}

}
