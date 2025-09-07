# Use Java 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar and wait-for-it.sh
COPY target/auth-service-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh /app/wait-for-it.sh

# Make wait-for-it.sh executable
RUN chmod +x /app/wait-for-it.sh

# Start app, wait for MySQL
CMD ["./wait-for-it.sh", "mysql:3306", "--timeout=60", "--", "java", "-jar", "app.jar"]
