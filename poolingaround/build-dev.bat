@echo off

docker buildx build -t poolingaround .

docker run --rm -it poolingaround
