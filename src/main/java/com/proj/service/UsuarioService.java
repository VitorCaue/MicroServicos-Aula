package com.proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proj.dto.UsuarioDto;
import com.proj.model.Usuario;
import com.proj.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public Page<UsuarioDto> findAll(Pageable pagination){
		return usuarioRepository.findAll(pagination).map(u -> new UsuarioDto(u));
	}
	
	public UsuarioDto findById(Long id) {
		return new UsuarioDto(usuarioRepository.getReferenceById(id));
	}
	
	@Transactional
	public UsuarioDto save(UsuarioDto usuarioDto) {
		Usuario usuario = Usuario.fromDto(usuarioDto); 
		return new UsuarioDto(usuarioRepository.save(usuario));
	}
	
	@Transactional
	public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
		Usuario usuario = Usuario.fromDto(usuarioDto);
		usuario.setId(id);
		return new UsuarioDto(usuarioRepository.save(usuario));
	}
	
	@Transactional
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	

}
