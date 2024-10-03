package com.proj.dto;
import com.proj.model.Usuario;

public record UsuarioDto(
		Long id, 
		String nome, 
		String email, 
		String senha,
		String telefone,
		String endereco) {
	
	public UsuarioDto(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getEmail(), 
				usuario.getSenha(), usuario.getTelefone(), usuario.getEndereco());
	}
	
	

}
