# Wekan unique ticket id generator

## Introduction

A simple Spring boot project to bring ticket numbering to Wekan https://github.com/wekan

Wekan is able to request a configurable url (webhook) when an event occurs inside a board.

When received, wekan-hook use Wekan api to update created card with a new title.

The title format is [NNN] title, where NNN in a unique id obtained from a new row of wekan-hook table.

## Install

### Build wekan-hook

Generate jar using mvn install.

Create a Dockerfile

```
FROM java:8
COPY . /usr/src/wekan-hook
WORKDIR /usr/src/wekan-hook
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","wekan-hook-0.0.1-SNAPSHOT.jar"]
```

Build it

```
docker build -t fr.hy.wekan-hook:0.1 ./
```

### Dockercompose

Modified Wekan docker-compose.yml file

```
version: '2'
services:
  wekan:
    image: wekanteam/wekan:latest
    links:
      - wekandb
      - wekan-hook
    environment:
      - MONGO_URL=mongodb://wekandb/wekan
      - ROOT_URL=http://HOST:PORT
    ports:
      - 9004:80

  wekandb:
    image: mongo:3.2.14
    volumes:
      - /path/to/data:/data/db

  wekan-hook:
    image: fr.hy.wekan-hook:0.1
```

Run it

```
docker-compose up -d
```
