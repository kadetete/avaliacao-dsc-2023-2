package br.edu.ifrn.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.livros.domain.autor.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
