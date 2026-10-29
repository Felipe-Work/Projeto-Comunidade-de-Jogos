CREATE DATABASE BibliotecaJogos;
USE BibliotecaJogos;

CREATE TABLE Jogo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    plataformas VARCHAR(50),
    codigoDeAcesso VARCHAR(50),
    tipo VARCHAR(30)
);

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf CHAR(11) NOT NULL UNIQUE,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Usuario_Jogo (
    id_usuario INT NOT NULL,
    id_jogo INT NOT NULL,
    PRIMARY KEY (id_usuario, id_jogo),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
    FOREIGN KEY (id_jogo) REFERENCES Jogo(id)
);

CREATE TABLE Comunidade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL
);

CREATE TABLE Comunidade_Usuario (
    id_comunidade INT NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY (id_comunidade, id_usuario),
    FOREIGN KEY (id_comunidade) REFERENCES Comunidade(id),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
);