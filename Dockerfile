# syntax=docker/dockerfile:1

# Build stage: Maven and the JDK exist only while compiling the application.
FROM maven:3.9.11-eclipse-temurin-21 AS build

# Work from a predictable directory inside the build container.
WORKDIR /build

# Copy the Maven descriptor first so dependency downloads can be cached separately.
COPY pom.xml .

# Download dependencies before copying source code; this speeds up rebuilds after source-only changes.
RUN mvn --batch-mode dependency:go-offline

# Copy the application source after the dependency-cache layer.
COPY src ./src

# Package the executable Spring Boot JAR and skip tests because this image-build step is not the test suite.
RUN mvn --batch-mode clean package -DskipTests

# Runtime stage: a smaller JRE image contains only what is needed to run the JAR.
FROM eclipse-temurin:21-jre-jammy AS runtime

# Create a dedicated non-root user to reduce the impact of a compromised process.
RUN groupadd --system spring && useradd --system --gid spring --create-home spring

# Set the directory from which the application will run.
WORKDIR /app

# Copy only the packaged executable from the build stage, not Maven, source code, or build cache.
COPY --from=build /build/target/*.jar app.jar

# Make the application file readable by the non-root runtime user.
RUN chown spring:spring app.jar

# Switch away from root before starting the application.
USER spring

# Document the HTTP port exposed by Spring Boot; publishing is configured by docker run or Compose.
EXPOSE 8080

# Start the Spring Boot executable when a container is launched.
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
