package br.com.ciss.funcionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ciss.funcionario.model.Funcionario;
import br.com.ciss.funcionario.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

	public Funcionario save(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public ResponseEntity<Funcionario> update(Long id, Funcionario funcionario) {
		return funcionarioRepository.findById(id).map(func -> {
			func.setNome(funcionario.getNome());
			func.setSobrenome(funcionario.getSobrenome());
			func.setEmail(funcionario.getEmail());
			func.setNumeroPis(funcionario.getNumeroPis());

			return ResponseEntity.ok().body(funcionarioRepository.save(func));
			
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> delete(Long id) {
		return funcionarioRepository.findById(id)
		.map(func -> {
			funcionarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
			
		}).orElse(ResponseEntity.notFound().build());
	}
}
