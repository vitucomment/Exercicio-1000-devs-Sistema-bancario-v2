# Exercicio-Banco1000-V2

<p align="center">
    <img alt="Badge indicando que o projeto foi criado em novembro de 2022" src="https://img.shields.io/badge/Data%20de%20cria%C3%A7%C3%A3o-Novembro%2F2022-blue">
    <img alt="Badge indicando que o status do projeto é 'Em desenvolvimento'" src="https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow">
</p>

<p align="center">
    • <a href="#Banco1000">Banco1000</a>
    • <a href="#descricao">Descrição</a>
    • <a href="#Desenvolvedor">Desenvolvedor</a>
</p>

<h2 id="Banco1000"> :computer_mouse: Banco1000?</h2>

O exercício proposto pela academia 1000 Devs, realizado pela Mesttra em parceria com a Johnson & Johnson MedTech, simula uma interface de gerenciamento de um banco, sem interface gráfica definida e rodando através do terminal do sistema operacional. O programa está conectado a um banco de dados (postgres) local, para realização da persistência dos dados.<br>
### RODE NA SUA MAQUINA:
    A aplicação funciona através da classe "Main.java" via IDE, ou via terminal do sistema rodando o JAR gerado e disponibilizado na raiz do projeto.
    Para funcionar, deve-se ter um banco Postgres na porta 5432, e um schema com o nome: "mildevs".
##### Script SQL para criação das tabelas:
    CREATE TABLE IF NOT EXISTS clientePF (
    numero integer PRIMARY KEY,
    agencia integer NOT NULL,
    telefone varchar(18) NOT NULL,
    saldo numeric(15,2) NOT NULL,
    limite numeric(15,2) NOT NULL,
    cpf varchar(20) UNIQUE NOT NULL,
    nome varchar(150) NOT NULL,
    idade integer NOT NULL
    );

    CREATE TABLE IF NOT EXISTS clientePJ (
    numero integer PRIMARY KEY,
    agencia integer NOT NULL,
    telefone varchar(18) NOT NULL,
    saldo numeric(15,2) NOT NULL,
    limite numeric(15,2) NOT NULL,
    cnpj varchar(50) UNIQUE NOT NULL,
    razaoSocial varchar(255) NOT NULL,
    nomeFantasia varchar(255) NOT NULL
    );

<h2 id="descricao">:pencil2: Descrição</h2>

### O que faz?
#### O programa conta com diversas funções atribuidas a um gerente:
    • Cadastro de clientes
    • Remoção
    • Consulta
    • Deposito
    • Transferencia
Todas as mudanças são realizadas no banco de dados depois de uma verificação, como por exemplo: O saldo deve ser suficiente para realização de uma transferência, caso não haja saldo suficiente, o limite é consultado, se o limite permitir a transferencia é realizada, caso o contrário a operação irá falhar.

### Qual o objetivo?

    • O objetivo pricipal é a comunicação de uma aplicação com o banco de dados, bem como a persistência das informações.
    • A conexão é realizada via JDBC, e a aplicação usa conceitos de POO, como herança e polimorfismo.
   






<h2 id="Desenvolvedor">:man: Desenvolvedor</h2>
<p>
<p align="center">
  <a href="https://github.com/vitucomment">
    <img width="120px" src="https://avatars.githubusercontent.com/u/101343369?" alt="Foto Victor Almeida">
  </a>
  <a href="https://github.com/NickyWasHere">
    <img width="120px" src="https://avatars.githubusercontent.com/u/108633713?" alt="Foto Nicolas Tenório"> 
  </a>
  <a href="https://github.com/ismaelcardosojr">
    <img width="120px" src="https://avatars.githubusercontent.com/u/112780968?" alt="Foto Ismael Cardoso">
  </a>
</p>


<p align="center">
<a href="https://www.linkedin.com/in/devitu-py/">@VictorAlmeida</a>
<a href="https://www.linkedin.com/in/nicolastenoriodev/">@NicolasTenorio</a>
<a href="https://www.linkedin.com/in/ismaelcardosojr/">@IsmaelCardoso</a>

</p>
</p>

<h2 id="funcionamento">:eye_speech_bubble: Funcionamento</h2>

   ![gif](https://github.com/vitucomment/Exercicio-Banco1000-V2/blob/master/gif/loom-message-25-november-2022-dsc9y2r2_mTCqwTnO.gif)
