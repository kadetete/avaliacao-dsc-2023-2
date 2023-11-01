package br.edu.ifrn.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.livros.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
