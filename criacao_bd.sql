CREATE DATABASE web_tarefas;

USE web_tarefas;

CREATE TABLE usuario (
	email VARCHAR(256) NOT NULL PRIMARY KEY,
    senha VARCHAR(16) NOT NULL,
    nome VARCHAR(126)
);

CREATE TABLE tarefas (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(256),
    descricao TEXT,
    fk_usuario_email VARCHAR(256) NOT NULL,
    FOREIGN KEY(fk_usuario_email) REFERENCES usuario(email)
);