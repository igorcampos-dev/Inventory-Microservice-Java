
# 📦 Microserviço de Usuários (User Microservice):

### 🔍 Endpoint POST /users/register:

recebe informações do usuário:

1.nome

2.sobrenome

3.endereço de e-mail

4.senha.

 
#### Cria um novo perfil de usuário no banco de dados.

### 📋 json recebido:

```json
 {
"user": {
"first_name": "João",
"last_name": "Silva",
"email": "joao.silva@email.com",
"password": "senha_segura"
}
}
```



### 🔍 Endpoint POST /users/login:

Espera receber credenciais de login, como nome de usuário e senha.
Autentica o usuário, gera tokens de acesso e atualiza informações de login.


### 📋 json recebido:

```json
{
"user": {
"email": "joao.silva@email.com",
"password": "senha_segura"
}
}
```


### 🔍 Endpoint GET /users/{userID}:

Espera receber o ID de um usuário.
Consulta o banco de dados para recuperar informações de perfil do usuário com base no ID.

### 📋 json recebido:


```json
{
  "user_id": "12345",
  "username": "joao_silva",
  "first_name": "João",
  "last_name": "Silva",
  "email": "joao.silva@email.com",
  "contact_details": {
    "address": "Rua da Amostra, 123"
  }
}
```




