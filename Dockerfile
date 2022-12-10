FROM openjdk:8-jdk-alpine

ENV JAR_NAME TheGluck-0.0.1-SNAPSHOT.jar
ENV WD /TheGluckApp/
RUN mkdir -p "$WD"
WORKDIR $WD
COPY ./target $WD

ENTRYPOINT java -jar $JAR_NAME