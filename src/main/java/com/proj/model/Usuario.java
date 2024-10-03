package com.proj.model;

import com.proj.dto.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 80, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(length = 100)
	private String senha;
	
	@Column(length = 15)
	private String Telefone;
	
	@Column(length = 200)
	private String endereco;
	
	public static Usuario fromDto(UsuarioDto usuarioDto) {
		return new Usuario(null, usuarioDto.nome(), usuarioDto.email(),
							usuarioDto.senha(), usuarioDto.telefone(), usuarioDto.endereco());
	}

}
