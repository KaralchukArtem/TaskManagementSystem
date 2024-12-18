FROM openjdk:17
WORKDIR /app
LABEL maintainer ="dockerhosting"
VOLUME /main-app
ADD target/app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]