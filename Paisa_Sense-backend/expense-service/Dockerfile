# Step 1: Base image
FROM openjdk:17-jdk-slim

# Step 2: Working directory
WORKDIR /app

# Step 3: Copy jar from target folder (same service)
COPY target/expense-service-0.0.1-SNAPSHOT.jar expense-service.jar

# Step 4: Run application
ENTRYPOINT ["java","-jar","expense-service.jar"]
