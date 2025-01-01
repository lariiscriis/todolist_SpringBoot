# TodoList Spring Boot Application

Este repositório contém uma aplicação de back-end desenvolvida em Java para gerenciar uma lista de tarefas (TodoList). A aplicação foi criada usando as seguintes tecnologias e práticas:

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Maven**: Gerenciador de dependências e build.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **API Rest**: Comunicação entre cliente e servidor.
- **Lombok**: Redução de boilerplate no código.
- **H2 Database Engine**: Banco de dados em memória para testes e desenvolvimento.
- **Segurança**: Implementação de autenticação e proteção de dados do usuário.
- **Tratamento de Exceções**: Gerenciamento de erros para garantir uma API robusta.
- **Deploy**: Hospedagem da aplicação no Render.

## Funcionalidades

- Cadastro de tarefas
- Atualização de tarefas
- Listagem de tarefas
- Autenticação e proteção de dados

## Como Testar a Aplicação

### Requisitos

- Um cliente REST (como [Postman](https://www.postman.com/) ou [Apidog](https://apidog.com/))

### Passo a Passo

1. **Acesse o endpoint base**
   - URL base: `https://todolist-springboot-sov7.onrender.com`

2. **Testando os Endpoints**

#### Cadastrar Usuário

- Método: `POST`
- Endpoint: `/users/`
- Corpo da Requisição (JSON):
  ```json
  {
    "name": "Larissa Cristina",
    "username":"lariiscriis",
    "password": "123"
  } 
  ```
- Descrição: Cria um novo usuário com os dados fornecidos.

#### Listar Tarefas

- Método: `GET`
- Endpoint: `/tasks/`
- Descrição: Retorna a lista de todas as tarefas cadastradas.

#### Criar uma Nova Tarefa

- Método: `POST`
- Endpoint: `/tasks/`
- Corpo da Requisição (JSON):
  ```json
  {
   "description": "Tarefa teste",
    "title":"Gravação de aula",
    "priority": "ALTA",
    "startAt": "2025-10-06T12:30:00",
    "endAt":"2025-10-10T15:30:00",
    "idUser": "id do usuario cadastrado exemplo: 7a70250d-9928-44a0-8a24-5d5f992c3751"  
  }
  ```
- Descrição: Cria uma nova tarefa com os dados fornecidos.

#### Atualizar uma Tarefa

- Método: `PUT`
- Endpoint: `/tasks/{id da tarefa}`
- Corpo da Requisição (JSON):
```json
 {
    "description": "Tarefa alterada"
}
```
- Descrição: Atualiza os dados de uma tarefa existente, altere qualquer campo da tarefa.






