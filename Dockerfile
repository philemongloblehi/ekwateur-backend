FROM adoptopenjdk/openjdk17:alpine-jre

ARG JAR_FILE=target/backend-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} backend-ekwateur.jar

COPY entrypoint.sh entrypoint.sh

RUN chmod 755 entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]
