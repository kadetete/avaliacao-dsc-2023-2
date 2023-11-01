package br.edu.ifrn.livros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrn.livros.domain.autor.Autor;
import br.edu.ifrn.livros.domain.livro.Livro;
import br.edu.ifrn.livros.repository.ListaLivroRepository;
import jakarta.transaction.Transactional;

@Service
public class ListaLivros {
    
    @Autowired
    private ListaLivroRepository repository;

    @Transactional
    public void inserirListaLivro(Autor autor, Livro livro) {
        repository.inserirListaLivro(autor.getId(), livro.getId());
    }
}
