#EQUIVALENTE FROM mysql:8.0.18
# Nos descargamos contenedor oficial 
# de OPENJDK, solo el proyecto JRE
FROM openjdk:8-jre-slim

#Definimos variable
ARG JAR_FILE=target/*.jar

# Copiando al interior del contenedor 
# en directorio raiz
COPY ${JAR_FILE} /api-rest-usuarios.jar
CMD java -jar /api-rest-usuarios.jar