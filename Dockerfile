FROM openjdk:8-jdk-alpine
WORKDIR /opt
ENV PORT 9000
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
EXPOSE 9000
