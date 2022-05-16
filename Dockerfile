FROM maven:3.6.3-jdk-8 AS MAVEN_BUILD

COPY pom.xml /build/

COPY src /build/src/

WORKDIR /build/

RUN mvn package

FROM openjdk:8-jre

WORKDIR /webapp

COPY --from=MAVEN_BUILD /build/target/ds-project-webapp-0.0.1-SNAPSHOT.jar /webapp/

ENTRYPOINT ["java", "-jar", "ds-project-webapp-0.0.1-SNAPSHOT.jar"]