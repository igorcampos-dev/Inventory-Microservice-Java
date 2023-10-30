CREATE TABLE notifications (
    id VARCHAR(255) PRIMARY KEY COMMENT 'Chave primária: Identificador exclusivo da notificação',
    order_id INT COMMENT 'ID do pedido associado à notificação',
    notification_type VARCHAR(255) NOT NULL COMMENT 'Tipo da notificação (e.g., e-mail, SMS, notificação no aplicativo)',
    recipient VARCHAR(255) COMMENT 'Destinatário da notificação (e.g., endereço de e-mail, número de telefone)',
    content TEXT COMMENT 'Conteúdo da notificação'
);