CREATE TABLE Inventory (
    id VARCHAR(255) PRIMARY KEY,
    quantity INT NOT NULL COMMENT 'Quantidade total de um produto',
    reserved_quantity INT NOT NULL DEFAULT 0 COMMENT 'Quantidade de unidades reservadas',
    INDEX (product_id) COMMENT 'Índice para consulta eficiente por ID do produto'
);
