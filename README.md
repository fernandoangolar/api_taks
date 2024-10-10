# Projeto de gerenciamento de tarefa

Este projeto consiste em uma API RESTful para gerenciar tarefas pessoais, desenvolvida em Java utilizando Spring Boot. A API inclui operações CRUD para tarefas e conta com autenticação de usuário usando JWT (JSON Web Token)

## Finalidade do projeto

O objetivo deste projeto é proporcionar aprendizado sobre:

- Operações CRUD com persistência de dados.
- Implementação de autenticação e autorização com JWT.
- Práticas de desenvolvimento de APIs com Spring Boot.

## Funcionalidades
- **CRUD de Tarefas**
- Autenticação de usuário com JWT
- Filtros de tarefas por status e prioridade

## Requisitos
- ***Java 17*
- **Spring Boot**
- **MYSQL** ou **POSTGRESQL**

## Estrutura do Projeto

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

## Instalação e Configuração

1. Clone o repositório
```
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

2. Navegue até o diretório do projeto
```
cd api_taks
```

3. Execute o projeto
```
./mvnw spring-boot:run
```

