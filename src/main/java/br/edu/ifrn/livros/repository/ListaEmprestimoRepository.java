package br.edu.ifrn.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifrn.livros.domain.listaemprestimo.ListaEmprestimo;

public interface ListaEmprestimoRepository extends JpaRepository<ListaEmprestimo, Long>{
    
    @Query(value = "INSERT INTO lista_emprestimo (id_emprestimo, id_livro, id_usuario) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void inserirListaEmprestimo(Long emprestimo, Long livro, Long usuario);
}
