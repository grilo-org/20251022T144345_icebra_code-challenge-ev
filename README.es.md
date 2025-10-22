# Proyecto Code Challenge EV <img src="https://www.neomacro.com/pt/wp-content/uploads/2015/06/neomacro.png" align="right" height="40px" />

[![en](https://img.shields.io/badge/lang-en-red.svg)](./README.md)
[![pt-br](https://img.shields.io/badge/lang-pt--br-green.svg)](./README.pt-br.md)
[![es](https://img.shields.io/badge/lang-es-yellow.svg)](./README.es.md)

---

# SpotBugs Gradle Plugin

Este es el complemento oficial de Gradle para ejecutar SpotBugs en el proyecto Java y Android.

![](https://github.com/spotbugs/spotbugs-gradle-plugin/workflows/Java%20CI/badge.svg)
[![Coverage Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.spotbugs.gradle&metric=coverage)](https://sonarcloud.io/component_measures?id=com.github.spotbugs.gradle&metric=coverage)
[![Debt](https://sonarcloud.io/api/project_badges/measure?project=com.github.spotbugs.gradle&metric=sqale_index)](https://sonarcloud.io/component_measures/domain/Maintainability?id=com.github.spotbugs.gradle)
[![Gradle Plugin Portal](https://img.shields.io/maven-metadata/v?label=Plugin+Portal&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Fcom%2Fgithub%2Fspotbugs%2Fcom.github.spotbugs.gradle.plugin%2Fmaven-metadata.xml)](https://plugins.gradle.org/plugin/com.github.spotbugs)
[![](https://img.shields.io/badge/groovydoc-latest-blightgreen?logo=groovy)](https://spotbugs-gradle-plugin.netlify.com/com/github/spotbugs/snom/package-summary.html)
---

API que proporciona retiros de dinero de cajeros automáticos. Después de un registro, el usuario puede comenzar a
realizar retiros.

1. Registro con nombre y correo electrónico (identificación única)
2. El primer retiro de dinero puede ser de un máximo de $50.00
3. El monto máximo para los retiros de dinero posteriores debe ser de $300.00
4. El valor mínimo para cualquier retiro de dinero es de $1.00
5. El usuario puede realizar un máximo de 5 retiros de dinero en 24 horas
6. Por cada retiro de dinero, el usuario deberá pagar una tarifa de acuerdo a la siguiente información:

|   Valor de retiro | Tarifa |
|------------------:|-------:|
|   $1,00 – $100,99 |     3% |
| $101,00 – $250,99 |     2% |
| $251,00 – $300,00 |     1% |

# Base de datos dockerizada h2

Este repositorio contiene la imagen `H2 Database` de `www.h2database.com`

### Información

- El usuario `h2` en la imagen se usa para la ejecución
- secuencia de comandos de inicio: `/opt/h2/bin/h2-start.sh`
- El volumen `/opt/h2-data` se puede usar para la persistencia
- Puertos: `8181` y `1521` están expuestos

## Crear imagen

Tome un Dockerfile y construya con los argumentos predeterminados:

~~~~
$ docker build -t code-challenge-ev/h2 .
~~~~

o simplemente use el script `build.sh`

## Ejecutando la aplicación en modo desarrollador