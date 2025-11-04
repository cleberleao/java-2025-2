CREATE TABLE IF NOT EXISTS pessoas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(120),
    nascimento DATE
);


select * from pessoas p


insert into pessoas (nome, email, nascimento ) values ('Teste', 'teste@teste', '2025-11-04')

UPDATE pessoas p SET  nome = 'teste 2' where id = 1

DELETE from pessoas where id = 2