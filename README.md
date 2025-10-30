# 🚀 Cadastro de Funcionários

Um sistema completo de gerenciamento de funcionários e cargos, construído com Spring Boot. O projeto expõe tanto uma **API RESTful** documentada com Swagger quanto uma **Interface Web** renderizada com Thymeleaf.

Este projeto foi desenvolvido como um sistema robusto para demonstrar habilidades de backend, incluindo arquitetura de microsserviços, manipulação de banco de dados, containerização com Docker e documentação de API.

---

## ✨ Funcionalidades Principais

O sistema permite o gerenciamento completo de duas entidades principais: **Funcionários** e **Cargos**.

* **API REST (em `/funcionarios` e `/cargos`):**
    * `GET /listar`: Lista todas as entidades.
    * `GET /listar/{id}`: Busca uma entidade por ID.
    * `POST /criar`: Cadastra uma nova entidade.
    * `PUT /alterar/{id}`: Altera uma entidade existente.
    * `DELETE /deletar/{id}`: Remove uma entidade.
* **Interface Web (em `/funcionarios/ui` e `/cargos/ui`):**
    * Interface visual para listar, criar, alterar e deletar funcionários e cargos.
    * Página de detalhes para cada funcionário.
    * Formulários dinâmicos que servem tanto para criação quanto para alteração.
* **Arquitetura:**
    * Uso do padrão **DTO (Data Transfer Object)** e **Mappers** para separar as entidades de banco de dados (`Model`) dos dados expostos na API e na UI.
    * Separação clara de responsabilidades entre Controllers, Services e Repositories.
* **Banco de Dados:**
    * Gerenciamento de migrações de banco de dados usando **Flyway**.
    * Configurado para rodar com **MySQL** em ambiente de produção (Docker) e **H2** em ambiente de testes.

---

## 🛠️ Tecnologias Utilizadas

Este projeto utiliza um stack moderno e robusto:

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Dados:** Spring Data JPA (Hibernate)
* **Banco de Dados:** MySQL (via Docker)
* **Banco de Testes:** H2 (em memória)
* **Migrações:** Flyway
* **API:** Spring Web (REST Controllers)
* **Interface Web (UI):** Thymeleaf
* **Documentação da API:** SpringDoc (Swagger)
* **Containerização:** Docker
* **Build:** Apache Maven
* **Utilitários:** Lombok

---

## 🏁 Como Executar o Projeto

Existem duas formas de executar a aplicação: localmente (via IntelliJ/Maven) ou via Docker.

### 1. Executando Localmente (Desenvolvimento)

**Pré-requisitos:**
* JDK 17 (ou superior)
* Maven 3.8 (ou superior)
* Docker Desktop (ou Docker Engine)

#### Passo 1: Iniciar o Banco de Dados MySQL
Este projeto precisa de um banco de dados MySQL rodando. Use o comando Docker abaixo para iniciar um contêiner MySQL pré-configurado:

```bash
docker run -d -p 3306:3306 --name mysql-funcionarios \
  -v cadastro-db-volume:/var/lib/mysql \
  -e MYSQL_ROOT_PASSWORD=sua-senha-root-segura \
  -e MYSQL_DATABASE=db_funcionarios \
  -e MYSQL_USER=admin_app \
  -e MYSQL_PASSWORD=senha_app \
  mysql
