@echo off

"../mvnw.cmd" clean package & java -cp "./target/poolingaround-1.0-SNAPSHOT.jar" solutions.vdesign.App
