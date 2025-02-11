# Etapa 1: Build da aplicação
FROM openjdk:17-jdk-slim AS build

WORKDIR /app

COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw ./

# Adicionar permissões de execução para o mvnw
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests


# Etapa 2: Rodando a aplicação
FROM openjdk:17-jdk-slim

WORKDIR /app

# Declarando as variáveis de ambiente
ENV DB_URL=
ENV DB_USERNAME=
ENV DB_PASSWORD=

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
