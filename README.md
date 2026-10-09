# Petlov — Automação de Testes Web

Projeto de automação de testes web da aplicação [Petlov](https://petlov.vercel.app), desenvolvido com Java para validar fluxos importantes da interface de cadastro de pontos de doação e a apresentação do slogan do site.

## Objetivo

Praticar e demonstrar automação de testes de interface (UI), verificando comportamentos esperados da aplicação e mensagens apresentadas ao usuário.

## Tecnologias

- **Java** — linguagem utilizada nos testes
- **Selenium WebDriver** — automação do navegador
- **Selenide** — seletores e verificações mais expressivas para testes web
- **JUnit 5** — estrutura e execução dos testes
- **Maven** — gerenciamento de dependências e execução
- **Chrome / ChromeDriver** — navegador utilizado na automação

## Cenários automatizados

| Classe | Cenários |
|---|---|
| `Cadastro` | Cadastro válido de ponto de doação; validação de e-mail inválido |
| `Selenium` | Cadastro de ponto de doação utilizando Selenium WebDriver |
| `Slogan` | Verificação do slogan exibido na página inicial |

## Estrutura do projeto

```text
Petlov_1/
├── pom.xml
└── src/
    └── test/
        └── java/
            ├── Cadastro.java
            ├── Selenium.java
            └── Slogan.java
```

## Pré-requisitos

- JDK compatível com a versão configurada no `pom.xml`
- IntelliJ IDEA
- Maven (o IntelliJ pode utilizar o Maven integrado)
- Google Chrome instalado

O Selenium Manager pode auxiliar na resolução do driver do navegador. Caso ocorra incompatibilidade entre a versão do Chrome e as dependências Selenium utilizadas, verifique as versões antes de alterar a configuração do projeto.

## Como executar pelo IntelliJ IDEA

1. Abra o projeto no IntelliJ IDEA.
2. Aguarde a importação das dependências Maven.
3. Abra a janela **Maven**.
4. Em **Lifecycle**, execute `test` para rodar os testes configurados no `pom.xml`.
5. Confira o resultado da execução no console do Maven.

Também é possível executar uma classe de teste individual pelo IntelliJ.

## Relatórios de teste

O projeto utiliza o Maven Surefire para gerar resultados individuais em `target/surefire-reports`, incluindo arquivos de texto e XML por classe.

Para gerar o relatório HTML consolidado após a execução dos testes, utilize a janela Maven do IntelliJ em **Execute Maven Goal** e execute:

```text
org.apache.maven.plugins:maven-surefire-report-plugin:3.2.5:report-only
```

O relatório HTML é gerado na pasta de relatórios do Maven, normalmente em `target/site/relatorio-testes.html`, conforme a configuração do projeto. Abra o arquivo no navegador para consultar os resultados das classes em conjunto.

> O relatório deve ser gerado novamente após cada nova execução dos testes para refletir os resultados mais recentes.

## Observações

Este repositório é um projeto de prática e portfólio em evolução. Os resultados dos testes podem depender da disponibilidade do site e da compatibilidade entre navegador, driver e dependências. Consulte o relatório gerado para verificar o resultado da execução mais recente.
