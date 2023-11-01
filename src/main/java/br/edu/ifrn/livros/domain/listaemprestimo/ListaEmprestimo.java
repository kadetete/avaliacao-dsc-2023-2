package br.edu.ifrn.livros.domain.listaemprestimo;

import br.edu.ifrn.livros.domain.emprestimo.Emprestimo;
import br.edu.ifrn.livros.domain.livro.Livro;
import br.edu.ifrn.livros.domain.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "lista_emprestimo")
@Entity(name = "lista_emprestimo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class ListaEmprestimo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_emprestimo")
    private Emprestimo emprestimo;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;
}
