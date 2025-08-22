# Compesa - API de Controle Hídrico

![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17+-blue?logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=spring&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

> API REST para controle e registro de responsabilidades sobre recursos hídricos, como poços e barragens.

## 📖 Sobre o Projeto

Este projeto foi desenvolvido para solucionar a necessidade de um sistema centralizado que gerencie e registre dados sobre o controle de recursos hídricos. A API permite saber de forma clara qual **unidade** é responsável por um determinado **tipo de controle** (poço, barragem, etc.), facilitando a gestão, a auditoria e a atribuição de responsabilidades.

O público-alvo são desenvolvedores e estudantes que desejam entender ou colaborar com uma aplicação backend robusta construída com Java e Spring Boot.

---

### 🗂️ Índice

* [Funcionalidades](#-funcionalidades)
* [Tecnologias Utilizadas](#-tecnologias-utilizadas)
* [Instalação e Configuração](#-instalação-e-configuração)
* [Uso da API](#️-uso-da-api)
* [Como Contribuir](#-como-contribuir)
* [Licença](#-licença)
* [Autor](#️-autor)

---

## ✨ Funcionalidades

A API oferece operações de CRUD (Criar, Ler, Atualizar, Deletar) para as seguintes entidades principais:

- **✅ Gestão de Tipos de Unidade:** Permite cadastrar os diferentes tipos de unidades responsáveis (ex: "Gerência Regional", "Equipe de Manutenção").
- **✅ Gestão de Tipos de Controle:** Permite cadastrar os tipos de pontos de controle hídrico (ex: "Poço Artesiano", "Barragem de Contenção").
- **✅ Gestão de Unidades de Controle:** Entidade principal que associa uma unidade a um ponto de controle específico, definindo a responsabilidade.

---

## 🚀 Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

- **Backend:**
  - [Java](https://www.java.com/)
  - [Spring Boot](https://spring.io/projects/spring-boot)
  - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
  - [Maven](https://maven.apache.org/) (Gerenciador de Dependências)
- **Banco de Dados:**
  - [MySQL](https://www.mysql.com/)
- **Ferramentas de Teste:**
  - [Postman](https://www.postman.com/) (para teste de endpoints)

---

## ⚙️ Instalação e Configuração

Siga os passos abaixo para executar o projeto em seu ambiente local.

### Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:
- [JDK](https://www.oracle.com/java/technologies/downloads/) (versão 17 ou superior)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)
- Um servidor de banco de dados [MySQL](https://dev.mysql.com/downloads/mysql/) rodando localmente ou em um container Docker.

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/VitorrSantoss/Compesa.git

# 2. Acesse a pasta do projeto
cd Compesa
```

**3. Configure o Banco de Dados**

- Crie um banco de dados no seu servidor MySQL. Por exemplo: `compesa_db`.
- Abra o arquivo `src/main/resources/application.properties`.
- Configure suas credenciais de acesso ao banco de dados:

```properties
# Exemplo de configuração do application.properties

# URL de conexão com o MySQL (altere o nome do banco se necessário)
spring.datasource.url=jdbc:mysql://localhost:3306/compesa_db?createDatabaseIfNotExist=true

# Usuário e senha do seu banco
spring.datasource.username=seu_usuario_mysql
spring.datasource.password=sua_senha_mysql

# Configurações do JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

**4. Execute a Aplicação**

```bash
# Use o Maven para compilar e rodar o projeto
mvn spring-boot:run
```

Após a execução, a API estará disponível em `http://localhost:8080`.

---

## ▶️ Uso da API

Você pode usar ferramentas como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para interagir com os endpoints da API.

### Endpoints Principais

*   `POST /api/tipos-unidade` - Cria um novo tipo de unidade.
*   `GET /api/tipos-unidade` - Lista todos os tipos de unidade.

*   `POST /api/tipos-controle` - Cria um novo tipo de controle.
*   `GET /api/tipos-controle` - Lista todos os tipos de controle.

*   `POST /api/unidades-controle` - Cria uma nova unidade de controle.
    *   **Exemplo de corpo (JSON):**
        ```json
        {
          "nome": "Poço Profundo P-01",
          "tipoUnidade": { "id": 1 },
          "tipoControle": { "id": 1 }
        }
        ```
*   `GET /api/unidades-controle` - Lista todas as unidades de controle.
*   `GET /api/unidades-controle/{id}` - Busca uma unidade de controle por ID.
*   `PUT /api/unidades-controle/{id}` - Atualiza uma unidade de controle.
*   `DELETE /api/unidades-controle/{id}` - Deleta uma unidade de controle.

*(Nota: Os caminhos dos endpoints são exemplos e podem variar. Consulte o código-fonte para os caminhos exatos).*

---

## 🤝 Como Contribuir

Contribuições são bem-vindas! Se você tem alguma ideia para melhorar este projeto, siga os passos abaixo:

1.  Faça um **Fork** do projeto.
2.  Crie uma nova Branch (`git checkout -b feature/sua-feature`).
3.  Faça o **Commit** das suas alterações (`git commit -m 'feat: Adiciona sua feature'`).
4.  Faça o **Push** para a Branch (`git push origin feature/sua-feature`).
5.  Abra um **Pull Request**.

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## ✍️ Autor

Feito por **Vitor Santos**.

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/VitorrSantoss)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vitorsantosll/) <!-- Adicione seu link do LinkedIn aqui -->
