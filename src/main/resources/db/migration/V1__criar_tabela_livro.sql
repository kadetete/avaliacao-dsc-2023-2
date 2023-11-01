create table livro (
    id int auto_increment primary key,
    titulo varchar(100) not null,
    isbn varchar(100) not null,
    ano_pub int not null,
    quant_copias int not null
);