# Documentação da aplicação TodoList

Esta documentação fornece uma visão geral da aplicação TodoList, incluindo tecnologias utilizadas, práticas adotadas, instruções de execução e descrição dos endpoints da API.

## Tecnologias Utilizadas

- Spring Boot
- Spring MVC
- Spring Data JPA
- SpringDoc OpenAPI 3
- PostgreSQL
- Docker

## Práticas Adotadas

- SOLID
- DRY
- YAGNI
- KISS
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com OpenAPI 3

## Instruções de Execução

Para executar a aplicação, é necessário ter o Java 21 instalado. Siga os passos abaixo:

1. Clone o repositório da aplicação.
2. Certifique-se de ter o Docker instalado e em execução.
3. No diretório raiz da aplicação, execute o seguinte comando:

   ```bash
   docker-compose up
`
Isso iniciará a aplicação com as configurações do Docker.

## Endpoints da API

### Criar uma nova tarefa:

```bash
$ http POST :8080/todos/create nome="Nome da Tarefa" descricao="Descrição da Tarefa" prioridade=1
```
```JSON
{
  "descricao": "Descrição da Tarefa",
  "id": 1,
  "nome": "Nome da Tarefa",
  "prioridade": 1,
  "realizado": false
}
```
### Listar todas as tarefas:
```bash
$ http GET :8080/todos/list
```
```JSON
[
  {
    "descricao": "Descrição da Tarefa",
    "id": 1,
    "nome": "Nome da Tarefa",
    "prioridade": 1,
    "realizado": false
  },
  {
    "descricao": "Descrição da Tarefa 2",
    "id": 2,
    "nome": "Nome da Tarefa 2",
    "prioridade": 2,
    "realizado": false
  },
]
```
```
``` bash
$ http PUT :8080/todos/update id=1 nome="Novo Nome" descricao="Nova Descrição" prioridade=2
````
### Atualizar uma tarefa existente:
```JSON
{
  "descricao": "Nova Descrição",
  "id": 1,
  "nome": "Novo Nome",
  "prioridade": 2,
  "realizado": false
}
```
### Deletar uma tarefa existente pelo ID:
```Bash
$ http DELETE :8080/todos/1

```