package br.com.ilog.tecnologia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.ilog.tecnologia.model.Curso;

//Remove @RepositoryRestResource below to disable auto REST api:
@RepositoryRestResource
public interface CursoRepository extends CrudRepository<Curso, Long>{}
