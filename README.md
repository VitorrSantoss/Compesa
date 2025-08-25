# Compesa SGA - Sistema de Gestão Hídrica

![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17+-blue?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen?logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue?logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-red?logo=apachemaven&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

> Sistema de Gestão de Ativos Hídricos - API REST para controle e gerenciamento de recursos hídricos, permitindo a gestão de tipos de unidades, tipos de controle e unidades de controle hídrico.



## 🎯 Sobre o Projeto

O **Compesa SGA** é uma API REST desenvolvida para gerenciar recursos hídricos de forma centralizada e eficiente. O sistema permite o controle de responsabilidades sobre diferentes tipos de recursos hídricos (poços, barragens, etc.), facilitando a gestão, auditoria e atribuição de responsabilidades.

### Objetivos

- **Centralização**: Unificar o controle de recursos hídricos em uma única plataforma
- **Rastreabilidade**: Manter histórico completo de alterações e responsáveis
- **Eficiência**: Automatizar processos de gestão e controle
- **Conformidade**: Garantir aderência às normas regulamentares

## 🏗️ Arquitetura

O sistema segue uma arquitetura em camadas baseada nos padrões do Spring Boot:

```
┌─────────────────┐
│   Controllers   │ ← Camada de Apresentação (REST API)
├─────────────────┤
│    Services     │ ← Camada de Negócio
├─────────────────┤
│  Repositories   │ ← Camada de Acesso a Dados
├─────────────────┤
│   Entities      │ ← Camada de Persistência
└─────────────────┘
```

### Padrões Utilizados

- **MVC (Model-View-Controller)**: Separação clara de responsabilidades
- **DTO (Data Transfer Object)**: Transferência de dados entre camadas
- **Repository Pattern**: Abstração da camada de persistência
- **Service Layer**: Encapsulamento da lógica de negócio

## 🚀 Tecnologias

### Backend
- **Java 17+**: Linguagem de programação
- **Spring Boot 3.5.3**: Framework principal
- **Spring Data JPA**: Abstração para persistência
- **Spring Validation**: Validação de dados
- **Spring Web**: Desenvolvimento web e REST
- **Lombok**: Redução de código boilerplate

### Banco de Dados
- **MySQL 8.0+**: Sistema de gerenciamento de banco de dados
- **Hibernate**: ORM (Object-Relational Mapping)

### Ferramentas
- **Maven**: Gerenciamento de dependências
- **Spring DevTools**: Desenvolvimento com hot reload

## ✨ Funcionalidades

### 🏢 Gestão de Tipos de Unidade
- ✅ Criar tipos de unidade (Gerência Regional, Equipe de Manutenção, etc.)
- ✅ Listar todos os tipos
- ✅ Buscar por ID
- ✅ Atualizar (completa e parcial)
- ✅ Remover tipos
- ✅ Controle de habilitação/desabilitação

### 🔧 Gestão de Tipos de Controle
- ✅ Cadastrar tipos de controle (Poço Artesiano, Barragem, etc.)
- ✅ Operações CRUD completas
- ✅ Atualização parcial via PATCH
- ✅ Validação de dados

### 🏗️ Gestão de Unidades de Controle
- ✅ Associar unidades a tipos de controle
- ✅ Controle de vigência
- ✅ Rastreamento de alterações
- ✅ Gestão de responsáveis
- ✅ Histórico de atualizações

## ⚙️ Instalação

### Pré-requisitos

Certifique-se de ter instalado:

- [JDK 17+](https://adoptium.net/)
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [MySQL 8.0+](https://dev.mysql.com/downloads/mysql/)
- [Git](https://git-scm.com/)

### Clone do Repositório

```bash
git clone https://github.com/VitorrSantoss/Compesa.git
cd Compesa
```

## 🔧 Configuração

### 1. Configuração do Banco de Dados

Crie um banco de dados MySQL:

```sql
CREATE DATABASE sga CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. Configuração da Aplicação

Edite o arquivo `src/main/resources/application.properties`:

```properties
# Configuração da aplicação
spring.application.name=compesa.sga

# Configuração do banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/sga?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuração do JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Configuração de logging
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=INFO
```

### 3. Execução da Aplicação

```bash
# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

## 📖 Uso da API

### Endpoints - Tipos de Unidade

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/tipoUnidade` | Lista todos os tipos de unidade |
| `GET` | `/tipoUnidade/{id}` | Busca tipo de unidade por ID |
| `POST` | `/tipoUnidade` | Cria novo tipo de unidade |
| `PUT` | `/tipoUnidade/{id}` | Atualiza tipo de unidade |
| `PATCH` | `/tipoUnidade/{id}` | Atualização parcial |
| `DELETE` | `/tipoUnidade/{id}` | Remove tipo de unidade |

### Endpoints - Tipos de Controle

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/tipoControle` | Lista todos os tipos de controle |
| `GET` | `/tipoControle/{id}` | Busca tipo de controle por ID |
| `POST` | `/tipoControle` | Cria novo tipo de controle |
| `PUT` | `/tipoControle/{id}` | Atualiza tipo de controle |
| `PATCH` | `/tipoControle/{id}` | Atualização parcial |
| `DELETE` | `/tipoControle/{id}` | Remove tipo de controle |

### Endpoints - Unidades de Controle

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/unidadeControle` | Lista todas as unidades de controle |
| `GET` | `/unidadeControle/{id}` | Busca unidade de controle por ID |
| `POST` | `/unidadeControle` | Cria nova unidade de controle |
| `PUT` | `/unidadeControle/{id}` | Atualiza unidade de controle |
| `PATCH` | `/unidadeControle/{id}` | Atualização parcial |
| `DELETE` | `/unidadeControle/{id}` | Remove unidade de controle |

### Exemplos de Uso

#### Criar Tipo de Unidade
```bash
curl -X POST http://localhost:8080/tipoUnidade \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Gerência Regional",
    "dataRegistro": "2024-01-15",
    "autor": "Admin",
    "disable": false
  }'
```

#### Criar Tipo de Controle
```bash
curl -X POST http://localhost:8080/tipoControle \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Poço Artesiano"
  }'
```

#### Criar Unidade de Controle
```bash
curl -X POST http://localhost:8080/unidadeControle \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Poço P-001 - Centro",
    "tipoControleId": {"id": 1},
    "disable": false,
    "vigencia": "2024-12-31",
    "autor": "João Silva",
    "ultimaAtualizacao": "2024-01-15"
  }'
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/compesa/sga/
│   │   ├── controller/          # Controllers REST
│   │   │   ├── TipoControleController.java
│   │   │   ├── TipoUnidadeController.java
│   │   │   └── UnidadeControleController.java
│   │   ├── dto/                 # Data Transfer Objects
│   │   │   ├── TipoControleDto.java
│   │   │   ├── TipoUnidadeDto.java
│   │   │   └── UnidadeControleDto.java
│   │   ├── model/               # Entidades JPA
│   │   │   ├── TipoControle.java
│   │   │   ├── TipoUnidade.java
│   │   │   └── UnidadeControle.java
│   │   ├── repository/          # Repositórios Spring Data
│   │   │   ├── TipoControleRepository.java
│   │   │   ├── TipoUnidadeRepository.java
│   │   │   └── UnidadeControleRepository.java
│   │   ├── services/            # Camada de serviços
│   │   │   ├── TipoControleService.java
│   │   │   ├── TipoUnidadeService.java
│   │   │   └── UnidadeControleService.java
│   │   └── Application.java     # Classe principal
│   └── resources/
│       └── application.properties
└── test/
    └── java/compesa/sga/
        └── ApplicationTests.java
```

## 🗃️ Modelo de Dados

### Diagrama ER Simplificado

```
┌─────────────────┐     ┌──────────────────┐     ┌─────────────────┐
│   TipoUnidade   │     │ UnidadeControle  │     │  TipoControle   │
├─────────────────┤     ├──────────────────┤     ├─────────────────┤
│ id (PK)         │     │ id (PK)          │     │ id (PK)         │
│ nome            │     │ nome             │────▶│ nome            │
│ dataRegistro    │     │ tipoControleId   │     └─────────────────┘
│ autor           │     │ disable          │
│ disable         │     │ vigencia         │
└─────────────────┘     │ autor            │
                        │ ultimaAtualizacao│
                        └──────────────────┘
```

### Relacionamentos

- **UnidadeControle** `N:1` **TipoControle**: Uma unidade de controle pertence a um tipo de controle
- **TipoUnidade**: Entidade independente para classificação de unidades organizacionais

## 🤝 Contribuição

Contribuições são sempre bem-vindas! Para contribuir:

### 1. Fork do Projeto
```bash
git clone https://github.com/seu-usuario/Compesa.git
```

### 2. Crie sua Feature Branch
```bash
git checkout -b feature/nova-funcionalidade
```

### 3. Commit suas Mudanças
```bash
git commit -m 'feat: Adiciona nova funcionalidade'
```

### 4. Push para a Branch
```bash
git push origin feature/nova-funcionalidade
```

### 5. Abra um Pull Request

### Padrões de Contribuição

- **Commits**: Use [Conventional Commits](https://conventionalcommits.org/)
- **Código**: Siga as convenções do Java e Spring Boot
- **Testes**: Inclua testes para novas funcionalidades
- **Documentação**: Atualize a documentação quando necessário

### Tipos de Commit

- `feat`: Nova funcionalidade
- `fix`: Correção de bug
- `docs`: Documentação
- `style`: Formatação
- `refactor`: Refatoração
- `test`: Testes
- `chore`: Manutenção

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 📞 Contato

**Vitor Santos**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/VitorrSantoss)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/vitorsantosll/)

---

<div align="center">
  <sub>Desenvolvido com ❤️ por <a href="https://github.com/VitorrSantoss">Vitor Santos</a></sub>
</div>
