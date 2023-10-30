# APP Colaboradores e Hierarquias

CRUD para cadastrar a hierarquia de colaboradores e suas respectivas senhas.

## Documentação da API

#### Salvar colaborador
#### Ao realizar o POST, a aplicação vai processar a força da senha seguindo as regra do site https://passwordmeter.com/
#### Para o parâmetro hierarquiaId (1 - Gestor, 2 - Coordenador e 3 - Auxiliar)
```http
  POST /colaboradores
```
###### Body
```json
{
  "nome": "DANILO",
  "senha": "TESTE123",
  "hierarquiaId": 2
}
```
###### Response
```json
{
  "id": 14,
  "nome": "DANILO",
  "score": 38,
  "complexity": "Fraco",
  "hierarquia": {
    "id": 2,
    "descricao": "COORDENADOR"
  }
}
```
#### Buscar colaborador por hierarquia
#### Retorna uma lista de colaboradores separados por hierarquia.
```http
  GET /colaboradores/hierarquia
```
###### Response
```json
{
  "colaboradorGerente": [
    {
      "id": 1,
      "nome": "HIGÃO DE GUARAREMA",
      "score": 95,
      "complexity": "Muito Forte",
      "hierarquia": {
        "id": 1,
        "descricao": "GERENTE"
      }
    }
  ]
}
```

### Foi utilizador o flyway-mysql para gerar as migrações na base de dados.

<h3 align="left">Linguagem e ferramentas:</h3>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
