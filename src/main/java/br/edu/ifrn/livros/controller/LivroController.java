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

import br.edu.ifrn.livros.domain.livro.Livro;
import br.edu.ifrn.livros.repository.LivroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarLivro(@RequestBody @Valid Livro livro,
            UriComponentsBuilder uriBuilder) {
        Livro livroLocal = repository.save(livro);
        var uri = uriBuilder.path("/livro/{id}").buildAndExpand(livroLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalharLivro(@PathVariable Long id) {
        var livro = repository.getReferenceById(id);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<Page<Livro>> listarLivro(@PageableDefault(size = 4, sort = { "titulo" }) Pageable paginacao) {
        var livros = repository.findAll(paginacao);
        return ResponseEntity.ok(livros);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluirLivro(@PathVariable Long id) {
        var livro = repository.getReferenceById(id);
        repository.delete(livro);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Livro> atualizarLivro(@RequestBody @Valid Livro livro) {
        Livro livroLocal = repository.findById(livro.getId()).get();

        livroLocal.setTitulo(livro.getTitulo());
        livroLocal.setIsbn(livro.getIsbn());
        livroLocal.setAno_pub(livro.getAno_pub());
        livroLocal.setQuant_copias(livro.getQuant_copias());

        return ResponseEntity.ok(livroLocal);
    }
}
