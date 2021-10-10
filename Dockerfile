# Builder stage
FROM maven:3.6.3-jdk-8-slim as builder
WORKDIR /opt
COPY . /opt
RUN mvn clean install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine as final
RUN adduser -D demo
USER demo

ENV JAVA_OPTS=""
WORKDIR /app
ARG DEPENDENCY=target/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app
COPY ssl/ /opt/ssl
ENTRYPOINT ["sh", "-c","java $JAVA_OPTS -cp app:app/lib/*","com.barath.app.Application"]
