# Catálogo de Filmes

Um projeto básico de CRUD (Create, Read, Update, Delete) para gerenciar um catálogo de filmes. Este projeto foi desenvolvido como demonstração de conhecimentos em desenvolvimento web, incluindo front-end, back-end e integração com banco de dados.

## Tecnologias Utilizadas

- **Back-end**: Java com Spring Boot
- **Front-end**: HTML, CSS e JavaScript
- **Banco de Dados**: H2 Database (em memória)
- **Ferramentas**: 
  - Spring Data JPA
  - Spring Web
  - Fetch API para comunicação entre front-end e back-end

---

## Funcionalidades

- **Listar Filmes**: Exibe todos os filmes cadastrados.
- **Adicionar Filme**: Permite adicionar um novo filme ao catálogo.
- **Editar Filme**: Atualiza informações de um filme existente.
- **Deletar Filme**: Remove um filme do catálogo.

---

## Estrutura do Projeto

### Back-end (`backend/`)
- **Application**: 
  - `CatalogoFilmesApplication.java`: Classe principal da aplicação Spring Boot, responsável por inicializar o servidor e configurar o ambiente.
- **Tests**:
  - `CatalogoFilmesApplicationTests.java`: Classe de teste gerada automaticamente para validar o carregamento do contexto do Spring Boot.
- **Controller**: Controla as rotas da API (`FilmeController.java`).
- **Service**: Contém a lógica de negócio (`FilmeService.java`).
- **Model**: Define a entidade Filme (`Filme.java`).
- **Repository**: Gerencia o acesso ao banco de dados (`FilmeRepository.java`).

### Front-end (`frontend/`)
- **HTML**: Interface básica do usuário (`index.html`).
- **CSS**: Estilização básica (`style.css`).
- **JavaScript**: Implementação das funcionalidades de listagem, adição, edição e exclusão (`script.js`).

---

## Configuração

### Configuração do Spring Boot (`src/main/resources/application.properties`)
- **spring.application.name**: Define o nome da aplicação como "catalogo-filmes".
- **Configuração do H2**: Configura a URL, o driver, o usuário e a senha para o banco de dados H2.
- **Console H2**: Ativa o console H2, permitindo o acesso ao banco de dados via navegador.
- **JPA**: Configura o JPA para usar o Hibernate e a estratégia `ddl-auto=update`, para criar e atualizar o esquema automaticamente.

### Configuração do Maven (`pom.xml`)
- **Dependências**:
  - `spring-boot-starter-data-jpa`: Para o suporte a JPA e integração com bancos de dados.
  - `spring-boot-starter-web`: Para configurar a parte web do Spring Boot.
  - `h2`: Para integrar o banco de dados H2 (em memória).
  - `spring-boot-starter-test`: Para testes no Spring Boot.
- **Build**: Utiliza o plugin `spring-boot-maven-plugin` para empacotar e executar o projeto como uma aplicação Spring Boot.

---

## Como Rodar

1. Clone o repositório.
2. Abra o projeto na sua IDE (ex: IntelliJ IDEA, Eclipse, Visual Studio).
3. Execute a classe `CatalogoFilmesApplication.java` como uma aplicação Spring Boot.
4. Acesse a interface web no seu navegador em `http://localhost:8080`.

---

## Contato

- **LinkedIn**: [ramon-v-braga](https://www.linkedin.com/in/ramon-v-braga)
- **GitHub**: [ramon-braga](https://github.com/ramon-braga)
