@echo off

docker run -it --rm --name poolingaround -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:3-eclipse-temurin-21 mvn clean package
