# Sistema de Cadastro de Funcionários - RH

## 📌 Sobre o Projeto

Este projeto é um sistema de cadastro de funcionários para um departamento de Recursos Humanos (RH). Ele permite o gerenciamento dos dados dos colaboradores de uma empresa, incluindo cadastro, atualização, consulta e remoção de registros.

## 🛠 Tecnologias Utilizadas

- **Backend:** Java com Spring Boot  
- **Banco de Dados:** MySQL  
- **ORM:** Hibernate (JPA)  
- **Gerenciamento de Dependências:** Maven  
- **Ferramenta de Testes:** Insomnia  

## 📂 Estrutura do Projeto

A entidade principal do sistema é **Funcionario**, que contém os seguintes atributos:

- `id (Long)` - Identificador único do funcionário  
- `nome (String)` - Nome completo  
- `cargo (String)` - Cargo ocupado na empresa  
- `salario (Double)` - Salário do funcionário  

## 🔧 Funcionalidades (CRUD)

- **Criar Colaborador (POST)** → `localhost:8080/colaboradores/nome/{nome}`  
- **Listar Todos os Colaboradores (GET)** → `localhost:8080/colaboradores`  
- **Buscar Colaborador por ID (GET)** → `localhost:8080/colaboradores/{id}`  
- **Buscar Colaborador por Nome (GET)** → `localhost:8080/colaboradores/nome/{nome}`  
- **Atualizar Dados do Colaborador (PUT)** → `localhost:8080/colaboradores`  
- **Remover Colaborador (DELETE)** → `localhost:8080/colaboradores/{id}`  

## 🚀 Como Executar o Projeto

### 1️⃣ Pré-requisitos:

- Java 17+  
- Spring Boot  
- MySQL  
- Maven  

### 2️⃣ Clonando o Repositório:

```sh
git clone https://github.com/anakelys/projeto-integrador1-grupo1.git
cd projeto-integrador1-grupo1
