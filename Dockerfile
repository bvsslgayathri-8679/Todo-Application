FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
