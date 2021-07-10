package br.com.ciss.funcionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome")
	@Size(min = 2, max = 30, message = "Informe de 2 a 30 caracteres")
	private String nome;
	
	@Column(name = "sobrenome")
	@Size(min = 2, max = 50, message = "Informe de 2 a 50 caracteres")
	private String sobrenome;
	
	@NotNull
	@Column(name = "email")
	@Email(message = "E-mail inválido")
	private String email;

	@Column(name = "numeroPis")
	@Pattern(regexp = "[0-9]*")
	private String numeroPis;

}
