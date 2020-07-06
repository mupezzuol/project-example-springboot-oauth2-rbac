FROM openjdk:8-jdk-alpine
LABEL maintainer="Murillo Pezzuol"
ENV APP_FILE project-example-springboot-oauth2-rbac-2.0.0.jar
ENV APP_HOME /usr/apps
EXPOSE 8080
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]