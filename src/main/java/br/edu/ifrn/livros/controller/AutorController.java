package br.edu.ifrn.livros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifrn.livros.domain.autor.Autor;
import br.edu.ifrn.livros.repository.AutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarAutor(@RequestBody @Valid Autor autor,
            UriComponentsBuilder uriBuilder) {
        Autor autorLocal = repository.save(autor);
        var uri = uriBuilder.path("/autor/{id}").buildAndExpand(autorLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalharAutor(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping
    public ResponseEntity<Page<Autor>> listarAutor(@PageableDefault(size = 4, sort = { "nome" }) Pageable paginacao) {
        var autores = repository.findAll(paginacao);
        return ResponseEntity.ok(autores);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluirAutor(@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        repository.delete(autor);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Autor> atualizarAutor(@RequestBody @Valid Autor autor) {
        Autor autorLocal = repository.findById(autor.getId()).get();

        autorLocal.setNome(autor.getNome());
        autorLocal.setNacionalidade(autor.getNacionalidade());

        return ResponseEntity.ok(autorLocal);
    }
}

