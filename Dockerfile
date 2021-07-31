FROM openjdk:11
WORKDIR /app
COPY target/movie-shop-0.0.1-SNAPSHOT.jar movie-shop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "movie-shop-0.0.1-SNAPSHOT.jar"]