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

import br.com.ilog.tecnologia.model.Usuario;
import br.com.ilog.tecnologia.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        try {
            List<Usuario> items = new ArrayList<Usuario>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {
        Optional<Usuario> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario item) {
        try {
            Usuario savedItem = repository.save(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody Usuario item) {
        Optional<Usuario> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Usuario existingItem = existingItemOptional.get();
            
            existingItem.setNome(item.getNome());
            existingItem.setTelefone(item.getTelefone());
            existingItem.setDataAdmissao(item.getDataAdmissao());
            existingItem.setLogin(item.getLogin());
            existingItem.setSenha(item.getSenha());

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
