# Descrição

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.

## Problema

Construa uma aplicação que exponha uma api web que valide se uma senha é válida.

Input: Uma senha (string).  
Output: Um boolean indicando se a senha é válida.

Embora nossas aplicações sejam escritas em Kotlin e C# (.net core), você não precisa escrever sua solução usando elas. Use a linguagem de programação que considera ter mais conhecimento.

## Pré-Requisitos
O projeto foi criado em Java com a utilização do Spring Boot por eu ter mais familiaridade com a linguagem. A utilização da Arquitetura do MVC foi feita por eu considerar ser mais organizada e por estar na maioria dos meus projetos de estudo.

Para compilar/desenvolver o projeto é necessário ter esses programas instalados:

- GIT
- Java JDK (Versão 11)
- Intellij IDEA ou Spring Tool Suite 4

## Setup e Configuração 

Para rodar o projeto Spring Boot é necessario clonar o projeto através do Git usando o comando: 
```text
git clone https://github.com/LucasMSnts/backend-challenge.git
```

Caso abra o projeto no Intellij IDEA, executar o Maven para poder instalar as dependências do projeto. Para executar o Maven, clique no icone do canto da tela, que está com o mesmo nome. Selecione o `senha-valida` e depois o `Lifecycle`, aparecendo alguns comandos para execução, selecione o `install` para instalar. Essa instalação pode demorar.

Já se abrir o projeto no programa Spring Tool Suite 4, a IDE vai automaticamente baixar as dependências do projeto.

Terminando a instalação estará pronto para compilar/desenvolver.

## Estrutura 

### Config
O arquivo do Config contém as configurações para liberar o CORS da aplicação. 

### Domain
Nessa pasta ocorre as definições dos campos que serão utilizados para as validações da Senha, tanto do campo de entrada (senha) como o de saida (que seria um `Boolean` confirmando se a senha é valida ou não).

### Resource
O arquivo dessa pasta é sobre a rota que será usada para validar a senha através do método GET, enviado pelo Header.

### Services
O arquivo é utilizado para chamar as funções que verificarão se os caracteres estão de acordo com as definições propostas.

## Exception
Foi criado essa exceção, que seria o `ValidacaoException`, caso ocorra algum erro na hora de executar o serviço de validação.

### Util

Esta pasta foi criada para deixar mais fácil futuras manutenções no código.

Para verificar se a senha possui Maiúscula, Minúscula e se tem os caracteres especiais, foi utilizado o `regex` por ser mais visível para manutenções. Por exemplo: nesse regex `(?=.*[!@#$%^&*()-+])` que está na função `ehMaiMinEspecial()` está verificando na String se tem algum desses caracteres especiais.

Já para verificação de caracteres repetidos ou se há espaço, que está na função `temRepetidoEspaco()`, foi utilizado um `Map` para mapear todos os caracteres da String adicionando quantas vezes tem o caracter repetido. Se tiver mais de 1, ou houver espaço, retornará o valor falso. 

Na verificação de caracteres repetidos foi pensado na ideia: 
```text
Teste!
``` 
Retornaria falso porque tem dois `e` repetindo na senha. 

Porém, se os caracter for o mesmo mas tiver um Maiúsculo e um Minúsculo (`TestE!`), retornaria verdadeiro já que a diferenciação de caracteres teria sido respeitada.
