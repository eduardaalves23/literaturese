package com.literaturese.repository;

import org.springframework.data.repository.CrudRepository;

import com.literaturese.models.Livro;
import com.literaturese.models.Usuario;

public interface LivroRepository extends CrudRepository<Livro, String> {
	
	Iterable<Livro> findByUsuario(Usuario usuario);
	Livro findById(long id);

}
