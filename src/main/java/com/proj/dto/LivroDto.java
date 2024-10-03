package com.proj.dto;

import com.proj.enums.LivroStatus;
import com.proj.model.Livro;

public record LivroDto(
		Long id, 
		String titulo, 
		String descricao, 
		Float nota, 
		Integer qtdePaginas, 
		LivroStatus livroStatus) {
	
	public LivroDto(Livro livro) {
		this(livro.getId(), livro.getTitulo(), livro.getDescricao(), 
				livro.getNota(), livro.getQtedPaginas(), livro.getLivroStatus());
	}

}
