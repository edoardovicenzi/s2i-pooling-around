# Welcome to Pooling Around Console

WARNING: Even though the product is localized in italian this documentation has been written in english.

## Documentation

You can find a better documentation by [clikcking here](https://edoardovicenzi.github.io/s2i-pooling-around/).

## Features

Pooling Around is an app that lets you book a trip with other people so you save money and make friends!

- See all trips
- Book a trip
- Cancel a reservetion
- Add a user
- Export all available trips in .csv
- Admin controls (for advanced users only!)
    - for the demo use "adminadmin" as password
    - See all the users
    - See all the reservations

# Get Started

## Requirements
You can build this project with java OR use docker (recommended)

- git
- Choose one:
    - Docker (recommended)
    - Native:
        - Java 21 SDK
        - Apche Maven 3.9.9 with java 21 compatibility

## Clone the repo

First of all clone the repositry:

```sh
git clone https://github.com/edoardovicenzi/s2i-pooling-around.git
```

Next cd into the app directory:

```sh
cd s2i-pooling-around/
```

## Build .jar

There are 3 ways to build this app into a jar file.

### Docker (recommended)

- Go to the github project directory and navigate to:
    ```sh
    cd poolingaround/
    ```
- Build the project into a .jar file like so:

#### Windows

    ```sh
    docker run -it --rm --name poolingaround -v "%cd%":/usr/src/mymaven -w /usr/src/mymaven maven:3-eclipse-temurin-21 mvn clean package
    ```
#### Unix, Powershell

    ```sh
    docker run -it --rm --name poolingaround -v "$(PWD)":/usr/src/mymaven -w /usr/src/mymaven maven:3-eclipse-temurin-21 mvn clean package
    ```
- The .jar file will be in placed in `target/` directory on the same level

### Use the scripts

WARNING: All the scripts require docker to run!

Go to the github project directory and navigate to:
    ```sh
    cd poolingaround/
    ```
#### Windows

    Run the `build.bat` batch file:
    ```bat
    build
    ```
#### Unix, Powershell

    Run the `build.bash` shell file:
    ```sh
    build
    ```
The .jar file will be in placed in `target/` directory on the same level.

### Maven CLI

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
- The .jar file will be in placed in `target/` directory on the same level

## Run the project
To run the .jar there are currently 3 supported ways.
### Docker (recommended)

- Go to the github project directory and navigate to:
    ```sh
    cd poolingaround/
    ```

- Run the following commands to build and run the project:
    ```sh
    docker buildx build -t poolingaround .
    
    docker run --rm -it poolingaround
    ```

### Use the scripts

WARNING: All the scripts require docker to run!

Go to the github project directory and navigate to:
    ```sh
    cd poolingaround/
    ```
#### Windows

    Run the `build_and_run.bat` batch file:
    ```bat
    build_and_run
    ```
#### Unix, Powershell

    Run the `build_and_run.bash` shell file:
    ```sh
    build_and_run
    ```
### Use java on the .jar file
This step requires you to have Java 21 JDK installed as well as the JAVA_HOME enviromental variable set to point to the right Java version (21)
Build the .jar first (see above) the run:
    ```sh
    java -cp target/poolingaround-1.0-SNAPSHOT.jar solutions.vdesign.App
    ```

