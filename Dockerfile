FROM maven

COPY ./pom.xml /opt/sqlinjection/pom.xml
COPY ./src /opt/sqlinjection/src

VOLUME  ["/root/.m2"]

WORKDIR /opt/sqlinjection

CMD ["mvn","jetty:run"]

EXPOSE 8080
