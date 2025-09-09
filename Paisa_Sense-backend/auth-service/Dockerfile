# Use Java 17 slim image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR
COPY target/auth-service-0.0.1-SNAPSHOT.jar app.jar

# Run the app
CMD ["java", "-jar", "app.jar"]
