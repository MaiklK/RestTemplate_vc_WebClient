FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/maiklk-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","maiklk-0.0.1-SNAPSHOT.jar"]