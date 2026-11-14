# Biblioteca: CRUD de Livros

Atividade Prática em Sala (UMC): CRUD com **Spring Boot, JPA, Thymeleaf e MySQL**.

**Alunos:** Isabelly Bertegani, Mariana Santos e Lais Tiburcio · **Tema:** Livro

## Como rodar

1. Abra o **XAMPP** e inicie **Apache** e **MySQL** (porta 3306).
2. Abra o projeto na IDE (IntelliJ / Eclipse / VS Code) e execute `BibliotecaApplication`
   (ou rode `mvn spring-boot:run`).
3. Acesse <http://localhost:8080>.

O banco `biblioteca` e a tabela `livro` são criados automaticamente.

### Senha do banco (fora do código)
O `application.properties` lê `DB_USER` e `DB_PASSWORD` de variáveis de ambiente.
No XAMPP o `root` não tem senha, então nada precisa ser configurado.
Se o seu MySQL tiver senha, defina antes de rodar:

- Windows (PowerShell): `$env:DB_PASSWORD="sua_senha"`
- Linux/Mac: `export DB_PASSWORD=sua_senha`

(Na IDE: *Run Configuration → Environment variables → `DB_PASSWORD=sua_senha`*.)

## Rotas

| Método | Rota                | Função                          |
|--------|---------------------|---------------------------------|
| GET    | `/livros`           | Listar (aceita `?busca=`)       |
| GET    | `/livros/novo`      | Formulário de cadastro          |
| POST   | `/livros/salvar`    | Salvar (valida + redirect)      |
| GET    | `/livros/editar/{id}` | Formulário de edição          |
| POST   | `/livros/excluir/{id}` | Excluir                      |

## Estrutura

```
model/       Livro (@Entity + Bean Validation)
repository/  LivroRepository (JpaRepository + findByTituloContainingIgnoreCase)
service/     LivroService (@Service, injeção por construtor)
controller/  LivroController (rotas) e HomeController (redireciona "/")
templates/   livros/lista.html e livros/form.html
static/css/  style.css
```
