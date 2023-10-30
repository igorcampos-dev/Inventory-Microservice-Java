# 📦 Microserviço de Estoque (Inventory Microservice):


### 🔍 Endpoint GET /inventory/{productID}:

#### como dele deve se comportar:

1.RECEBE O ID

2.PROCURA NO BANCO

3.RETORNA A QUANTIDADE DISPONIVEL:

### 📋 recebe por parametro:

### **_localhost:8080/inventory/3_**


### o que ele deve retornar:
```json
{
"quantity": "23"
}
```

### 🔍 Endpoint PUT /reserve/productId/{productId}/quantityId/{quantityId}:


### Reserva uma unidade do produto no estoque (ou registra a reserva) quando um pedido é criado no Microserviço de Pedido.


### como o sistema vai se comportar:

1.RECEBE O ID DE UM PRODUTO E A QUANTIDADE DE UNIDADES

2.SISTEMA VALIDA

3.RESERVA AS UNIDADES DESSE PRODUTO.


### 📋 json recebido: (como parametro)


### **_localhost:8080/inventory/3/23_**





### 🔍 Endpoint PUT /release/productId/{productId}/quantityId/{quantityId}:

### Libera uma reserva de produto no estoque, que pode ocorrer quando um pedido é cancelado ou falha.


como ele deve se comportar:

SISTEMA RECEBE O ID DO PRODUTO E A QUANTIDADE DE UNIDADES

O SISTEMA ATUALIZARÁ ESSA UNIDADE COMO DISPONIVEL DE NOVO

TENDO EM VISTA QUE O USUARIO PODE TER CANCELADO A COMPRA.



