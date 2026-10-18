# Edu ERP — PROJ DE ESTUDOO

ERP educacional em Java 21 + Spring Boot 3 + PostgreSQL.

## Como rodar

1. **Suba o banco de dados** (precisa do Docker instalado):
   ```
   docker compose up -d
   ```
   Isso sobe um Postgres em `localhost:5432` (usuário `eduerp`, senha `eduerp`, banco `eduerp`).

2. **Rode a aplicação** pela IntelliJ (botão Run na classe `EduErpApplication`) ou por terminal:
   ```
   ./mvnw spring-boot:run
   ```

3. As tabelas são criadas automaticamente pelo **Flyway** na primeira execução
   (veja `src/main/resources/db/migration`).

4. A API sobe em `http://localhost:8080`.

## Endpoints disponíveis (módulo Aluno) - Testado com Swagger UI

| Método | Rota              | Descrição            |
|--------|-------------------|-----------------------|
| POST   | /api/alunos       | Cria um aluno         |
| GET    | /api/alunos       | Lista todos os alunos |
| GET    | /api/alunos/{id}  | Busca um aluno por id |
| PUT    | /api/alunos/{id}  | Atualiza um aluno     |
| DELETE | /api/alunos/{id}  | Remove um aluno       |

### Exemplo de requisição (criar aluno)

```
POST /api/alunos
Content-Type: application/json

{
  "nome": "Maria Silva",
  "email": "maria.silva@exemplo.com",
  "dataNascimento": "2005-03-14"
}
```

## Estrutura do projeto

```
src/main/java/br/com/eduerp/
  ├── EduErpApplication.java       # classe principal
  ├── aluno/                       # módulo Aluno (entidade, repositório, service, controller, DTOs)
  └── config/                      # segurança e tratamento global de erros
src/main/resources/
  ├── application.properties       # configuração da aplicação
  └── db/migration/                # migrations do Flyway (versionamento do schema)
```

## Próximos passos sugeridos

1. Testar o CRUD de Aluno com Postman/Insomnia
2. Adicionar autenticação real (JWT) em `SecurityConfig` — está marcado com um comentário no código
3. Criar o próximo módulo (Turma, depois Matrícula), seguindo o mesmo padrão de pastas
4. Adicionar testes unitários em `AlunoService` com JUnit + Mockito


## Objetivo do Proj + Explicações

***Esse é um projeto sem fins lucrativos, apenas para aprendizado e aprimoramento das minhas skills. 

O objetivo desse projeto é criar uma aplicação 100% funcional de um ERP Educacional. Estou fazendo isso para aprendizado,
sem qualquer fim lucrativo.

O nome é de uma escola de verdade. Escolhi essa escola pública porque foi onde estudei, fiz meu ensino fundamental lá, 
então tenho um certo apego emocional por ela, mesmo tendo sofrido bulling nesse período da minha vida por ser nerd kkkk. Isso aqui NÃO E UM PRODUTO, NÃO POSSUI QUALQUER FIM LUCRATIVO, é apenas um projeto de estudo,
não tenho nenhuma responsabilidade sobre uso indevido, cópia, ou qualquer evento de terceiros sobre esse software!

Esse código não e nenhum tipo de cópia de qualquer software já existente, estou fazendo tudo por conta, utilizando apenas 
as ferramentas elencadas acima, IA e o tico e teco que residem em minha cabeça. 

OBS: IA utilizada nesse projeto: Todas, no plano gratuito. Via CLI, utilizado Junie integrado ao IntelliJ.