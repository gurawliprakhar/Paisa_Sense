# Use official OpenJDK 17 image as base
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy JAR directly (after building locally with mvn)
COPY target/ai-parser-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
