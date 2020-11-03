package br.com.ilog.tecnologia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ilog.tecnologia.model.Curso;
import br.com.ilog.tecnologia.model.Usuario;
import br.com.ilog.tecnologia.repository.CursoRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/course")
class CursoController {

    @Autowired
    CursoRepository repository;

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        try {
            List<Curso> items = new ArrayList<Curso>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") Long id) {
        Optional<Curso> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso item) {
        try {
            Curso savedItem = repository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Curso> update(@PathVariable("id") Long id, @RequestBody Curso item) {
        Optional<Curso> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Curso existingItem = existingItemOptional.get();

            List<Usuario> usuarios = item.getUsuarios();
            
            existingItem.setTitulo(item.getTitulo());
            existingItem.setDescricao(item.getDescricao());
            existingItem.setCargaHoraria(item.getCargaHoraria());
            existingItem.setValor(item.getValor());
            existingItem.setUsuarios(usuarios);


            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
