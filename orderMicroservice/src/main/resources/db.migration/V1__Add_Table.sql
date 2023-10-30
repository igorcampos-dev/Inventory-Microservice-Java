CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Chave primária: Identificador único do pedido',
    customer_id INT NOT NULL COMMENT 'ID do cliente que fez o pedido',
    first_name VARCHAR(255) NOT NULL COMMENT 'Nome do cliente',
    last_name VARCHAR(255) NOT NULL COMMENT 'Sobrenome do cliente',
    email VARCHAR(255) NOT NULL UNIQUE COMMENT 'Endereço de e-mail único do cliente',
    address VARCHAR(255) NOT NULL COMMENT 'Endereço de entrega do pedido',
    product_id VARCHAR(255) NOT NULL COMMENT 'ID do produto no pedido',
    quantity INT NOT NULL COMMENT 'Quantidade do produto no pedido',
    payment_method VARCHAR(255) NOT NULL COMMENT 'Método de pagamento utilizado no pedido',
    card_number VARCHAR(255) NOT NULL UNIQUE COMMENT 'Número do cartão de crédito (sensível)',
    expiration_date VARCHAR(255) NOT NULL COMMENT 'Data de validade do cartão de crédito (sensível)',
    cvv VARCHAR(255) NOT NULL COMMENT 'Código CVV do cartão de crédito (sensível)',
    status VARCHAR(255) NOT NULL COMMENT 'Status do pedido (e.g., confirmado, pendente, entregue)',
    delivery_status VARCHAR(255) NOT NULL COMMENT 'Status de entrega do pedido',
    INDEX (order_id) COMMENT 'Índice para consulta eficiente por ID do pedido'

);