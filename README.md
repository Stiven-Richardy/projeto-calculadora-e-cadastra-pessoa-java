# 🖥️ Projeto: Calculadora e Cadastro de Pessoas (Java GUI)

Este projeto acadêmico foi desenvolvido como parte da disciplina de Linguagem de Programação II, com o objetivo de aplicar os conhecimentos adquiridos sobre a construção de interfaces gráficas em Java Swing. O trabalho é dividido em duas partes: a implementação de uma **Calculadora** funcional e a criação de um Formulário de **Cadastro de Pessoas**.

## 🎯 Objetivos

**1. Calculadora**
- Construir uma interface gráfica para uma calculadora, com botões numéricos, operadores (+, -, *, /) e botões de controle (C, =) .
- Implementar as quatro operações aritméticas básicas.
- Implementar a função "Clear" (botão C) para limpar a memória e o visor.
- Aplicar tratamento de erros e exceções (`try`, `catch`, `finally`) para operações inválidas (ex: divisão por zero).

**2. Cadastro de Pessoa**
- Criar a classe `Pessoa` com atributos (`nome`, `sexo`, `idade`) e um contador estático (`kp`) para rastrear o número de instâncias .
- Desenvolver um formulário (`FormPessoa`) para a entrada de dados.
- Implementar validações de formulário (campos obrigatórios, 'M' ou 'F' para sexo).
- Gerenciar os dados com os botões "OK" (transferir dados para o objeto) e "Mostrar" (exibir dados do objeto).
- Explorar diferentes componentes Swing para a entrada do "Sexo", evoluindo de um `TextField` (Versão 01) para um `JComboBox` (Versão 02) e `JRadioButton` (Versão 03).

## 🛠️ Ferramentas Utilizadas

- Java
- VS Code
- Git e GitHub

## 🗂️ Estrutura do Projeto

```
📁 projeto-calculadora-e-cadastra-pessoa-java/
├── 📁 calculadora/
│   └── 📄 FormCalculadora.java
├── 📁 cadastroPessoa/
│   ├── 📄 Pessoa.java
│   ├── 📄 FormPessoaV1.java
│   ├── 📄 FormPessoaV2.java
│   └── 📄 FormPessoaV3.java
├── 📄 .gitignore
└── 📄 README.md
```

## 🚀 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/Stiven-Richardy/projeto-calculadora-e-cadastra-pessoa-java
```

2. Acesse a pasta do projeto:
```bash
cd projeto-calculadora-e-cadastra-pessoa-java
```

3. Compile os arquivos:
```bash
javac calculadora/*.java
javac pessoa/*.java
```

4. Execute os programas (Um de cada vez):
```bash
java calculadora/FormCalculadora
java pessoa/FormPessoaV1
java pessoa/FormPessoaV2
java pessoa/FormPessoaV3
```

## 👨‍🏫 Autores

- **Stiven Richardy Silva Rodrigues**  
  Estudante de Análise e Desenvolvimento de Sistemas | IFSP — Campus Cubatão  
  [@Stiven-Richardy](https://github.com/Stiven-Richardy)

- **Guilherme Mendes de Sousa**  
  Estudante de Análise e Desenvolvimento de Sistemas | IFSP — Campus Cubatão  
  [@Guilh3rme-M3ndes](https://github.com/Guilh3rme-M3ndes)

## 📚 Referências

- Documentação oficial do Java: https://docs.oracle.com/en/java/
