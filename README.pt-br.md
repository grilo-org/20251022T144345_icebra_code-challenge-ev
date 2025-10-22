# Projeto Desafio de Código EV <img src="https://www.neomacro.com/pt/wp-content/uploads/2015/06/neomacro.png" align="right" height="40px" />

[![en](https://img.shields.io/badge/lang-en-red.svg)](./README.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](./README.pt-br.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](./README.es.md)

---

# SpotBugs Gradle Plugin

Este é o plug-in oficial do Gradle para executar SpotBugs no projeto Java e Android.

![](https://github.com/spotbugs/spotbugs-gradle-plugin/workflows/Java%20CI/badge.svg)
[![Coverage Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.spotbugs.gradle&metric=coverage)](https://sonarcloud.io/component_measures?id=com.github.spotbugs.gradle&metric=coverage)
[![Debt](https://sonarcloud.io/api/project_badges/measure?project=com.github.spotbugs.gradle&metric=sqale_index)](https://sonarcloud.io/component_measures/domain/Maintainability?id=com.github.spotbugs.gradle)
[![Gradle Plugin Portal](https://img.shields.io/maven-metadata/v?label=Plugin+Portal&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Fcom%2Fgithub%2Fspotbugs%2Fcom.github.spotbugs.gradle.plugin%2Fmaven-metadata.xml)](https://plugins.gradle.org/plugin/com.github.spotbugs)
[![](https://img.shields.io/badge/groovydoc-latest-blightgreen?logo=groovy)](https://spotbugs-gradle-plugin.netlify.com/com/github/spotbugs/snom/package-summary.html)
---

APIs que fornecem saques de dinheiro de caixas eletrônicos. Após um registro, o usuário pode começar a fazer saques.

1. Inscrição com nome e e-mail (ID único)
2. A primeira retirada de dinheiro pode ser de no máximo de US$ 50,00
3. O valor máximo para as retiradas de dinheiro subsequentes deve ser de US$ 300,00
4. O valor mínimo para qualquer retirada de dinheiro é de US$ 1,00
5. O usuário pode fazer no máximo 5 saques de dinheiro em 24 horas
6. Para cada saque de dinheiro, o usuário deverá pagar uma taxa de acordo com as informações abaixo:

|    Valor do saque | Taxa |
|------------------:|-----:|
|   $1,00 – $100,99 |   3% |
| $101,00 – $250,99 |   2% |
| $251,00 – $300,00 |   1% |

# Banco de dados h2 dockerizado

Este repositório contém a imagem `H2 Database` de `www.h2database.com`

### Informações

- O usuário `h2` na imagem é usado para execução
- iniciar script: `/opt/h2/bin/h2-start.sh`
- Volume `/opt/h2-data` pode ser usado para persistência
- Portas: `8181` e `1521` são expostos

## Criar imagem

Pegue um Dockerfile e construa com os argumentos padrão:

~~~~
$ docker build -t code-challenge-ev/h2 .
~~~~

ou simplesmente use o script `build.sh`

## Executando o aplicativo no modo dev