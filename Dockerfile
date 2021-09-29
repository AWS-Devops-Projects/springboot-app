FROM quay.io/eclipse/che-java8-maven:next

MAINTAINER tech-tejendra

USER root

COPY src /home/app/src
COPY pom.xml /home/app

#ERROR
#RUN nocmd

RUN mkdir -p /var/local/SP

RUN mvn -f /home/app/pom.xml clean package

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/home/app/target/spring-boot-hello-world-0.0.1-SNAPSHOT.jar"]
