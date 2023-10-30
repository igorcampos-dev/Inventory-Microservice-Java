CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Chave primária: Identificador exclusivo do usuário',
    first_name VARCHAR(255) NOT NULL COMMENT 'Primeiro nome do usuário',
    last_name VARCHAR(255) NOT NULL COMMENT 'Sobrenome do usuário',
    email VARCHAR(255) UNIQUE NOT NULL COMMENT 'Endereço de e-mail único do usuário',
    password VARCHAR(255) NOT NULL COMMENT 'Senha do usuário',
    address VARCHAR(255) COMMENT 'Endereço do usuário'
);
