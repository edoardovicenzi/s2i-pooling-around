# Get Started

## Requirements

- git
- Java 21 SDK
- One of:
    - Docker
    - Apche Maven 3.9.9 with java 21 compatibility

## Clone the repo

First of all clone the repositry:

```sh
git clone https://github.com/edoardovicenzi/s2i-pooling-around.git
```
Next cd into the app directory


```sh
cd s2i-pooling-around/
```

## Maven considerations

There are 3 ways to build this app into a jar file.

This app uses heavly and exensively the maven wrapper (mvnw) so it is the reccomended way.

### Thorugh Maven wrapper

This is the reccomended way.

Install the wrapper

- With docker
```sh
docker run --rm -v "$(pwd):/app" -w /app maven:3-eclipse-temurin-21 mvn wrapper:wrapper
```

- With maven CLI
```sh
mvn wrapper:wrapper
```

<!-- TODO: DOCS: Finish mvnw installation guide  -->
### Through maven cli

This is the most straight forward approach.

- Install Apache Maven 3.9.9 by following the [official instructions](https://maven.apache.org/install.html).
- Go to the github project directory and navigate to:
    ```sh
    cd poolingaround/
    ```
- Build the project into a .jar file like so:
    ```sh
    mvn clean package
    ```
- The .jar file will be in placed in `target` directory on the same level
- execute the app with java
    ```sh
    java -cp target/poolingaround-1.0-SNAPSHOT.jar solutions.vdesign.App
    ```

