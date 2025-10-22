# Code Challenge EV Project <img src="https://www.neomacro.com/pt/wp-content/uploads/2015/06/neomacro.png" align="right" height="40px" />

[![en](https://img.shields.io/badge/lang-en-red.svg)](./README.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](./README.pt-br.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](./README.es.md)
---

# SpotBugs Gradle Plugin

This is the official Gradle Plugin to run SpotBugs on Java and Android project.

![](https://github.com/spotbugs/spotbugs-gradle-plugin/workflows/Java%20CI/badge.svg)
[![Coverage Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.spotbugs.gradle&metric=coverage)](https://sonarcloud.io/component_measures?id=com.github.spotbugs.gradle&metric=coverage)
[![Debt](https://sonarcloud.io/api/project_badges/measure?project=com.github.spotbugs.gradle&metric=sqale_index)](https://sonarcloud.io/component_measures/domain/Maintainability?id=com.github.spotbugs.gradle)
[![Gradle Plugin Portal](https://img.shields.io/maven-metadata/v?label=Plugin+Portal&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Fcom%2Fgithub%2Fspotbugs%2Fcom.github.spotbugs.gradle.plugin%2Fmaven-metadata.xml)](https://plugins.gradle.org/plugin/com.github.spotbugs)
[![](https://img.shields.io/badge/groovydoc-latest-blightgreen?logo=groovy)](https://spotbugs-gradle-plugin.netlify.com/com/github/spotbugs/snom/package-summary.html)
---

APIs that provides money withdrawals from ATMs. After a registration, the user can start making withdrawals.

1. Registration with name and email (unique ID)
2. First money withdrawal can be a maximum of $50.00
3. Maximum amount for the subsequent money withdrawals must be $300.00
4. Minimum value for any money withdrawal is $1.00
5. User can make a maximum of 5 money withdrawals in 24 hours
6. For each money withdrawal, the user must pay a fee according to the table below:

|   Withdrawl value | Fee |
|------------------:|----:|
|   $1,00 – $100,99 |  3% |
| $101,00 – $250,99 |  2% |
| $251,00 – $300,00 |  1% |

# Dockerized h2 database

This repository contains `H2 Database` image from `www.h2database.com`

### Info

- User `h2` in image is used for execution
- start script: `/opt/h2/bin/h2-start.sh`
- Volume `/opt/h2-data` can be used for persistance
- Ports: `8181` and `1521` are exposed

## Build Image

Take a Dockerfile and build with the default arguments:

~~~~
$ docker build -t code-challenge-ev/h2 .
~~~~

or simply use the `build.sh` script

## Running the application in dev mode

    TODO

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/code-challenge-ev-1.0.0-SNAPSHOT-runner`
