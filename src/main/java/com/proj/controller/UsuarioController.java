package com.proj.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proj.dto.LivroDto;
import com.proj.dto.UsuarioDto;
import com.proj.service.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/usuarios",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<Page<UsuarioDto>> findAll(@PageableDefault(size= 10) Pageable pagination){
		return ResponseEntity.ok(usuarioService.findAll(pagination));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> findById(@PathVariable Long id){
		return ResponseEntity.ok(usuarioService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto usuarioDto){
		return ResponseEntity.status(201).body(usuarioService.save(usuarioDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
		return ResponseEntity.ok(usuarioService.update(id, usuarioDto));
	}

}