# Use OpenJDK 17
FROM openjdk:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven build files
COPY target/sms-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port (e.g., 8090)
EXPOSE 8090

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
