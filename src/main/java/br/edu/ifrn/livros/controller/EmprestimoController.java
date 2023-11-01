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

import br.edu.ifrn.livros.domain.emprestimo.Emprestimo;
import br.edu.ifrn.livros.repository.EmprestimoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarEmprestimo(@RequestBody @Valid Emprestimo emprestimo,
            UriComponentsBuilder uriBuilder) {
        Emprestimo emprestimoLocal = repository.save(emprestimo);
        var uri = uriBuilder.path("/emprestimo/{id}").buildAndExpand(emprestimoLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalharEmprestimo(@PathVariable Long id) {
        var emprestimo = repository.getReferenceById(id);
        return ResponseEntity.ok(emprestimo);
    }

    @GetMapping
    public ResponseEntity<Page<Emprestimo>> listarEmprestimo(@PageableDefault(size = 4, sort = { "id" }) Pageable paginacao) {
        var emprestimos = repository.findAll(paginacao);
        return ResponseEntity.ok(emprestimos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluirEmprestimo(@PathVariable Long id) {
        var emprestimo = repository.getReferenceById(id);
        repository.delete(emprestimo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Emprestimo> atualizarEmprestimo(@RequestBody @Valid Emprestimo emprestimo) {
        Emprestimo emprestimoLocal = repository.findById(emprestimo.getId()).get();

        emprestimoLocal.setData_emprestimo(emprestimo.getData_emprestimo());
        emprestimoLocal.setData_devolucao(emprestimo.getData_devolucao());

        return ResponseEntity.ok(emprestimoLocal);
    }
}
