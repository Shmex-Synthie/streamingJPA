# Sistema de Streaming de Vídeos - Spring JPA

Este projeto é um sistema de streaming de vídeos desenvolvido em **Java 22** com **Spring Boot 3.5.5** e **Spring Data JPA**, utilizando **MySQL** como banco de dados.

O sistema permite:
- Gerenciar usuários e seus perfis
- Cadastrar vídeos e categorias
- Registrar visualizações e avaliações de vídeos
- Consultar vídeos por título ou categoria
- Listar os top 10 vídeos mais bem avaliados
- Listar os top 10 vídeos mais assistidos
- Identificar o usuário que mais assistiu vídeos

---

## Estrutura de Classes

![Diagrama UML](diagrama_UML.png)


As principais entidades do sistema são:
- **Usuario**: representa um usuário do sistema.
- **Perfil**: cada usuário pode ter múltiplos perfis.
- **Categoria**: categorias dos vídeos (Ex: Ação, Comédia, Drama).
- **Video**: vídeos disponíveis no sistema.
- **Visualizacao**: registra cada visualização de um vídeo por um perfil.
- **Avaliacao**: registra avaliações de vídeos por perfis.

---

## Tecnologias Utilizadas

- Java 22
- Spring Boot 3.5.5
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- PlantUML (para diagramas)
- TerminalApp (interface de linha de comando)

---

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/streamingJPA.git
