FROM ubuntu:18.04
RUN apt update
RUN apt-get -y install openjdk-17-jdk
WORKDIR /opt/app
COPY src /opt/app/src
COPY pom.xml /opt/app/
COPY mvnw /opt/app/
COPY .mvn /opt/app/.mvn
RUN chmod +x mvnw
RUN ./mvnw -Dmaven.test.skip=true clean install
RUN ls -l
COPY target/mega-taxi-0.0.1-SNAPSHOT.jar /opt/app/service.jar
ENTRYPOINT  ["java","-jar","/opt/app/service.jar"]
