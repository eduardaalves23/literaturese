package com.literaturese.repository;

import org.springframework.data.repository.CrudRepository;

import com.literaturese.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
	
	Usuario findByCodigo(long codigo);

}
