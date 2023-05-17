#!/bin/sh

echo "The app is starting ..."

java -jar -Xms1g -Xmx4g -XX:+ExitOnOutOfMemoryError -Dspring.profiles.active=prod "backend-ekwateur.jar"
