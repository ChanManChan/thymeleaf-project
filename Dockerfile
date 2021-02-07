FROM ubuntu:latest

MAINTAINER Nanda Gopal "ngopal253@gmail.com"

RUN apt-get update && apt-get install -y openjdk-11-jdk

ENV version=docker-v1
#ENV dbuser=<username>
ENV dbuser=postgres

#ENV dbpass=<password>
ENV dbpass=postgres

#ENV jdbcurl=jdbc:driver://hostname:port/dbName
ENV jdbcurl=jdbc:postgresql://localhost:5432/pma-spring

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]