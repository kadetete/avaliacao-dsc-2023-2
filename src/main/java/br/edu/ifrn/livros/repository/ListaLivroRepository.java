package br.edu.ifrn.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifrn.livros.domain.listalivro.ListaLivro;

public interface ListaLivroRepository extends JpaRepository<ListaLivro, Long>{
    
    @Query(value = "INSERT INTO lista_livros (autor_id, livro_id) VALUES (?1, ?2)", nativeQuery = true)
    void inserirListaLivro(Long autor, Long livro);
}
