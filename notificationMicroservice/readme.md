# 📦 Microserviço de Notificação (Notification Microservice):

### Endpoint POST /notifications/send:

recebe informações de notificação {incluindo o ID do pedido, tipo de notificação, destinatário e conteúdo}

Envia notificações para o destinatário especificado com base nas informações fornecidas.

### 📋 json recebido:


```json
{
"notification": {
"order_id": "12345",
"notification_type": "Entrega",
"recipient": "joao_silva",
"content": "Seu pedido foi entregue com sucesso."
}
}
```