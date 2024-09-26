# AC1 - Sistema de Gerenciamento de Categorias e Produtos

## Descrição
Este projeto é uma aplicação Spring Boot que implementa um sistema simples para gerenciar categorias e produtos. A aplicação fornece uma API RESTful que permite realizar operações de cadastro, listagem e consulta de categorias e produtos.

## Tecnologias Utilizadas
- Java 21.0.2
- Spring Boot
- Maven
- JPA/Hibernate
- Banco de Dados: Atualmente o código está configurado para utilizar o H2, porém pode ser modificado através do arquivo `application.properties`
- RESTful API

## Funcionalidades Principais

### Gerenciamento de Categorias
- **Cadastrar Categoria**: Permite criar novas categorias com nome e descrição.
- **Listar Categorias**: Recupera todas as categorias cadastradas.
- **Consultar Categoria por ID**: Obtém detalhes de uma categoria específica.

### Gerenciamento de Produtos
- **Cadastrar Produto**: Permite criar novos produtos vinculados a uma categoria existente.
- **Listar Produtos**: Recupera todos os produtos cadastrados.
- **Consultar Produto por ID**: Obtém detalhes de um produto específico.

## Estrutura do Projeto

- **controller**: Contém os controladores REST.
- **dto**: Objetos de transferência de dados para comunicação com a API.
- **model**: Entidades que representam as tabelas do banco de dados.
- **repository**: Interfaces de acesso aos dados.
- **service**: Contém a lógica de negócio.

## Considerações
- **Associações**: Um produto está associado a uma categoria existente.
- **DTOs e Entidades**: Utiliza-se DTOs para transferir dados entre a aplicação e o cliente, mantendo as entidades separadas da camada de apresentação.
- **Banco de Dados**: Certifique-se de que o banco de dados está configurado corretamente antes de executar a aplicação.

## Autor
Jéser Cáceres Marcelino - Desenvolvedor: [Github - Jéser Cáceres Marcelino](https://github.com/jesercaceres)




