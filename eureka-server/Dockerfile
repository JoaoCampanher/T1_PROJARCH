FROM maven:3.9-amazoncorretto-17-debian
WORKDIR /app

COPY ./mvnw .

COPY pom.xml .

COPY . .

RUN mvn dependency:go-offline

RUN mvn clean package -DskipTests

EXPOSE 8761

CMD ["java","-jar","target/eureka-server-0.0.1-SNAPSHOT.jar"]