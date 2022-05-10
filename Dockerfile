FROM openjdk:11-jre-slim

EXPOSE 8080

COPY ./build/libs/*.jar app.jar

RUN --mount=type=secret,id=JDBC_URL \ 
    --mount=type=secret,id=DATABASE_USERNAME \
    --mount=type=secret,id=DATABASE_PASSWORD 

ENV JDBC_URL $(cat /run/secrets/JDBC_URL)
ENV DATABASE_USERNAME $(cat /run/secrets/DATABASE_USERNAME)
ENV DATABASE_PASSWORD $(cat /run/secrets/DATABASE_PASSWORD)

ENTRYPOINT ["java","-jar","/app.jar"]