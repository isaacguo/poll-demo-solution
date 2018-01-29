#!/bin/bash
docker-compose down
docker ps -a | grep isaacguo/poll- | awk {'print $1'} | xargs docker stop
docker ps -a | grep isaacguo/poll- | awk {'print $1'} | xargs docker rm
docker images | grep isaacguo/poll- | awk {'print $3'} | xargs docker rmi
docker-compose pull
docker-compose run poll_start_poll-config
docker-compose up -d
