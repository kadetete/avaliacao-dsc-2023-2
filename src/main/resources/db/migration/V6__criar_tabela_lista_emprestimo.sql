create table lista_emprestimo (
    id int auto_increment primary key,
    id_usuario int not null,
    id_emprestimo int not null,
    id_livro int null,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_emprestimo) REFERENCES emprestimo(id),
    FOREIGN KEY (id_livro) REFERENCES livro(id)
);