# Build step
FROM maven:3-eclipse-temurin-21 AS build

WORKDIR /usr/src/mymaven
COPY . .
RUN ["mvn", "clean", "package"]


# Run step

FROM eclipse-temurin:21-jdk AS run

WORKDIR /app

COPY --from=build /usr/src/mymaven/target .
ENTRYPOINT ["java", "-cp", "poolingaround-1.0-SNAPSHOT.jar", "solutions.vdesign.App"]
