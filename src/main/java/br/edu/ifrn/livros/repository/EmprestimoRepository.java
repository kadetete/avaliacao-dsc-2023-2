package br.edu.ifrn.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.livros.domain.emprestimo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
    
}
