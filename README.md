# 🚀 Sistema de Cadastro de Funcionários

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

Um projeto full-stack (API + Web UI) para gerenciamento de funcionários e seus respectivos cargos, construído com as tecnologias mais modernas do ecossistema Spring.

---

## ✨ Funcionalidades

* **API RESTful Completa:** Gerenciamento total (CRUD) para `Funcionários` e `Cargos`.
* **Interface Web (UI):** Páginas em Thymeleaf para listar, criar, alterar e deletar registros de forma visual.
* **Documentação Interativa:** API 100% documentada com Swagger/SpringDoc.
* **Migrações de Banco:** Versionamento de banco de dados robusto usando Flyway.
* **Containerização:** Aplicação e banco de dados prontos para rodar em containers Docker.

## 🛠️ Stack Tecnológico

* **Backend:** Java 17, Spring Boot
* **Dados:** Spring Data JPA (Hibernate)
* **Banco de Dados:** MySQL (e H2 para testes)
* **Interface:** Thymeleaf & CSS
* **Ferramentas:** Maven, Docker, Lombok
* **API Doc:** Swagger (SpringDoc OpenAPI 3)

---

## 🏁 Como Executar o Projeto

A forma mais fácil de rodar este projeto é com Docker e um arquivo `.env`.

### 1. Inicie o Banco de Dados
Este projeto precisa de um banco de dados MySQL. Use o comando Docker abaixo para iniciar um contêiner pré-configurado:

```bash
docker run -d -p 3306:3306 --name mysql-funcionarios \
  -v cadastro-db-volume:/var/lib/mysql \
  -e MYSQL_ROOT_PASSWORD=sua-senha-root-segura \
  -e MYSQL_DATABASE=db_funcionarios \
  -e MYSQL_USER=admin_app \
  -e MYSQL_PASSWORD=senha_app \
  mysql
