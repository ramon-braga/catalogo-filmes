# Usando uma imagem base com JDK 17
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho no container
WORKDIR /app

# Copiar os arquivos do projeto para o diretório de trabalho
COPY . .

# Instalar o Maven
RUN apt-get update && apt-get install -y maven

# Rodar o Maven para constuir o projeto
RUN mvn clean install

# Expôr a porta em que o aplicativo vai rodar
EXPOSE 8080

# Comando para rodar o aplicativo
CMD ["java", "-jar", "target/catalogo-filmes-0.0.1-SNAPSHOT.jar"]