# Projeto de gerenciamento de tarefa

Este projeto consiste em uma API ara gerenciar tarefas pessoais

## Funcionalidades
- **CRUD de Tarefas**
- Autenticação de usuário com JWT
- Filtros de tarefas por status e prioridade

## Requisitos
- ***Java 17*
- **Spring Boot**
- **MYSQL** ou **POSTGRESQL**

``` 
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   └── gerenciadortarefas/
│   │   │       ├── controller/    # Controladores REST
│   │   │       ├── dto/           # Objetos de transferência de dados (DTOs)
│   │   │       ├── model/         # Entidades e modelos de dados
│   │   │       ├── repository/    # Repositórios para interação com banco de dados
│   │   │       ├── service/       # Lógica de negócio e serviços
│   │   │       └── security/      # Configuração de segurança (JWT, autenticação)
│   └── resources/
│       └── application.properties # Configurações da aplicação (banco de dados, etc)
```
