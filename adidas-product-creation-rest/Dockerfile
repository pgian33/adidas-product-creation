FROM java:8-jdk-alpine
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY ./target/adidas-product-creation-rest-0.0.1-SNAPSHOT.jar adidas-product-creation-rest-0.0.1-SNAPSHOT.jar
COPY rest-entrypoint.sh rest-entrypoint.sh
RUN chmod 755 rest-entrypoint.sh
EXPOSE 8080
ENTRYPOINT exec java -jar /adidas-product-creation-rest-0.0.1-SNAPSHOT.jar