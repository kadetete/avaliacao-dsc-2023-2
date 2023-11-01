package br.edu.ifrn.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.livros.domain.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
