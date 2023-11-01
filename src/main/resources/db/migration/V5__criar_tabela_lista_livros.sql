create table lista_livros (
    id int auto_increment primary key,
    autor_id int not null,
    livro_id int not null,
    FOREIGN KEY (autor_id) REFERENCES autor(id),
    FOREIGN KEY (livro_id) REFERENCES livro(id)
);