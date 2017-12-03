FROM java:8

LABEL maintainer "ravi2523096@gmail.com"

EXPOSE 8080
VOLUME ["/usr/src", "/usr/src/myapp"]
ADD /target/cloudbank-0.0.1-SNAPSHOT.jar /usr/src/myapp/cloudbank-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/myapp
ENTRYPOINT ["java","-jar","cloudbank-0.0.1-SNAPSHOT.jar"]
