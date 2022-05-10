FROM openjdk:11-jre-slim

EXPOSE 8080

COPY ./build/libs/*.jar app.jar

RUN --mount=type=secret,id=JDBC_URL \ 
    export MYSQL_HOST=$(cat /run/secrets/JDBC_URL) && \
    --mount=type=secret,id=DATABASE_USERNAME \
    export DATABASE_USERNAME=$(cat /run/secrets/DATABASE_USERNAME) && \
    --mount=type=secret,id=DATABASE_PASSWORD \ 
    export DATABASE_PASSWORD=$(cat /run/secrets/DATABASE_PASSWORD) && \

    ENTRYPOINT ["java","-jar","/app.jar"]