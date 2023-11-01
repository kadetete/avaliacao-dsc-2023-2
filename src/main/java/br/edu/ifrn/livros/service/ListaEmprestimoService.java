package br.edu.ifrn.livros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.livros.domain.emprestimo.Emprestimo;
import br.edu.ifrn.livros.domain.livro.Livro;
import br.edu.ifrn.livros.domain.usuario.Usuario;
import br.edu.ifrn.livros.repository.ListaEmprestimoRepository;
import jakarta.transaction.Transactional;

@Service
public class ListaEmprestimoService {
    
    @Autowired
    private ListaEmprestimoRepository repository;

    @Transactional
    public void inserirEmprestimo(Usuario usuario, Emprestimo emprestimo, Livro livro) {
        repository.inserirListaEmprestimo(emprestimo.getId(), livro.getId(), usuario.getId());
    }
}
