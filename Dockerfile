# Use Maven with Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copy all project files
COPY . /app

# Expose both ports
EXPOSE 8080

# Run the Spring Boot application
CMD ["mvn", "spring-boot:run"]