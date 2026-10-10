
# Stage 1: Build using Java 21 and Maven
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src src

# Retry the Maven build if Maven Central is temporarily busy
RUN for i in 1 2 3 4 5; do \
      mvn -B -ntp clean package -DskipTests && exit 0; \
      echo "Maven build failed. Retrying in 15 seconds..."; \
      sleep 15; \
    done; exit 1

# Stage 2: Run using Java 21
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
