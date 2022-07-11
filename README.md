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
É necessario ter esses programas instalados para compilar/desenvolver o projeto

- GIT
- Java JDK (Versão 11)
- Intellij IDEA ou Spring Boot

## Setup e Configuração 

Para rodar o projeto Spring Boot é necessario executar o Maven para poder instalar as dependencias do projeto.

## Estrutura 

### Config
O arquivo do Config contém as configurações para liberar o CORS da aplicação 

### Domain
Nessa pasta ocorre as definições dos campos que serão utilizados para a execução das validações da Senha, tanto do campo de entrada, que seria a senha, e da saida, que seria um `Boolean` confirmando se a senha é valida ou não.

### Resource
O arquivo dessa pasta são sobre as rotas que são usadas para 

### Services
o arquivo é utilizado para chamar a função onde verificar se os cararcteres estão de acordo com as definições 

### Util

Criei essa pasta para deixar mais facil para alteração no codigo.

Para verificar se a senha é Maiuscula, Minuscula e se tem os caracteres especiais, foi utilizado o `regex` por ser mais tranquilo e mais visivel para manutenções. Por exemplo: nesse regex `(?=.*[!@#$%^&*()-+])` está verificando na String se tem algum desses caracteres especiais.

No caso de verificar se tem repetida e se tem espaço, foi utilizado um `Map` para mapear todos os caracteres da String adicionando quantas vezes tem o caracter repetido, se tiver mais 1, retornará o valor falso. Tambem é feito uma verificação nesse processo de ver se o caracter não é um espaço, se for, retorna falso.

