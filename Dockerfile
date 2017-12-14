FROM java:8

LABEL maintainer "ravi2523096@gmail.com"

EXPOSE 8080
VOLUME ["/usr/src", "/usr/src/myapp"]
ADD /target/online-bank-0.0.1-SNAPSHOT.jar /online-bank-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","online-bank-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["sh", "-c", "java -jar online-bank-0.0.1-SNAPSHOT.jar"]
