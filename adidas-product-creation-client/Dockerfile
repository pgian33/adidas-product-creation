FROM java:8-jdk-alpine
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY target/adidas-product-creation-client-0.0.1-SNAPSHOT.jar adidas-product-creation-client-0.0.1-SNAPSHOT.jar
COPY client-entrypoint.sh client-entrypoint.sh
RUN chmod 755 client-entrypoint.sh
EXPOSE 8084
ENTRYPOINT exec java -jar /adidas-product-creation-client-0.0.1-SNAPSHOT.jar