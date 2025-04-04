#!bin/bash
docker buildx build -t poolingaround .

docker run --rm -it poolingaround
