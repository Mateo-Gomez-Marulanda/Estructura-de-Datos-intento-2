# demo

Descripciín basisca de su Proyecto de POO ...

## ⚠️ IMPORTANTE: Cambio de Rama

**Para acceder al resto de archivos del proyecto, debe cambiar a la rama `repoJava21`.**

Debido a problemas con el manejo de versiones de Java en el repositorio principal, todo el contenido del proyecto se encuentra en la rama `repoJava21`.

Para cambiar de rama, use el siguiente comando:

```shell
git checkout repoJava21
```

# Autores

- Autor 1
- Autor 2

# Herramientas

- [java 17](https://adoptium.net/es)
- [junit 5.10.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.0)
- [maven](https://maven.apache.org)


# Construcción y pruebas

Para compilar el proyecto puede usar el comando:

```shell
mvn clean compile
```

Para ejecutar las pruebas puede usar el comando: 

```shell
 mvn clean test
```

Para generar el jar puede usar el comando: 

```shell
 mvn clean package
```

y para ejecutar el jar

```shell
 java -jar target/demo-1.0.jar
```
