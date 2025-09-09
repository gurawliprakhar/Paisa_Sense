# Use Java 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar and wait-for-it.sh
COPY target/auth-service-0.0.1-SNAPSHOT.jar app.jar

# Start app, wait for MySQL
CMD [ "mysql:3306", "--timeout=60", "--", "java", "-jar", "app.jar"]
