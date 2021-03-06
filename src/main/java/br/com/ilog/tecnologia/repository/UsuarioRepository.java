package br.com.ilog.tecnologia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ilog.tecnologia.model.Usuario;


@RepositoryRestResource
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{}
