#!/bin/bash

docker build -f ./python/Dockerfile -t my-ai-fastapi-app ./python
docker build -f ./Dockerfile -t my-spring-boot-app ./

docker network create gameup-network 2>nul

docker run -d --network gameup-network --name my-ai-fastapi-app -p 8081:8081 my-ai-fastapi-app

docker run -d --network gameup-network --name my-spring-boot-app -p 8080:8080 my-spring-boot-app



