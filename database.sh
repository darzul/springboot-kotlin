#!/bin/bash

# open bash
# docker exec -it testdb  bash

# connect to database
# psql tutorial postgres

# see logs
# docker logs -f testdb

PROJECT_DIR='/Users/guillaume.bourderye/Git/springboot-kotlin'

cd "$(dirname "$0")"

name='testdb'
image='postgres:14.2'

(docker stop $name && docker rm $name) 2> /dev/null

docker pull $image
docker run --name $name \
  -v $PROJECT_DIR/sql:/docker-entrypoint-initdb.d \
  -e POSTGRES_PASSWORD='test' \
  -p 5432:5432 \
  -d $image \
