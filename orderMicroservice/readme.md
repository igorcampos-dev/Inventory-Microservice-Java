# 📦 **Microserviço de Pedido (Order Microservice)**

O Microserviço de Pedido é responsável por gerenciar pedidos, desde a criação até a entrega. Ele oferece três principais endpoints para interação:

# ✉️ Endpoint POST /orders

### **Este endpoint permite a criação de novos pedidos. Ele recebe um JSON contendo informações do pedido, incluindo detalhes do cliente, produtos selecionados e informações de pagamento. O microserviço executa as seguintes etapas:**

1. Valida os dados do pedido, incluindo a disponibilidade dos produtos no estoque.
2. Inicia a transação de pagamento, comunicando-se com o Microserviço de Pagamento.
3. Se o pagamento for bem-sucedido, atualiza o status do pedido para "confirmado."
4. Reserva os produtos no estoque.
5. Inicia o processo de preparação para envio.
6. Envia notificações de confirmação para o cliente.**

### 📋 Exemplo de Pedido Recebido:

```json
{
"customer": {
"customer_id": "12345",
"first_name": "João",
"last_name": "Silva",
"email": "joao.silva@email.com",
"address": "Rua da Amostra, 123"
},
"products": [
{
"product_id": "P001",
"quantity": 2
},
{
"product_id": "P002",
"quantity": 3
}
],
"payment": {
"payment_method": "credit_card",
"card_number": "1234-5678-9012-3456",
"expiration_date": "12/25",
"cvv": "123"
}
}
```


# 🔍 Endpoint GET /orders/{orderID}


### **Este endpoint permite a consulta de informações de um pedido com base no seu ID. O microserviço realiza as seguintes ações:**


Verifica se o pedido existe no banco de dados.
Retorna as informações do pedido, incluindo os detalhes do cliente, informações de pagamento e o status do pedido.

### 📋 Exemplo de Resposta:

```json
{
  "customer": {
    "first_name": "João",
    "last_name": "Silva",
    "email": "joao.silva@email.com",
    "address": "Rua da Amostra, 123"
  },
  "payment": {
    "payment_method": "credit_card",
    "card_number": "1234-5678-9012-3456",
    "expiration_date": "12/25"
  },
  "status": "PENDENTE"
}
```


# 🔍  Endpoint PUT /orders/{orderID}

Espera receber o ID de um pedido e informações de atualização, como o status de entrega.

como ele se comporta:   

1.RECEBE O ID DO USUARIO E INFORMACOES DE ATUALIZAÇÃO

2.ATUALIZA O STATUS COM BASE NAS INFORMACOES QUE ELE RECEBE

### 📋 exemplo de como o sistema vai receber:

```json
{
"order_id": "12345",
"delivery_status": "Entregue"
}

```
