FROM java:8

LABEL maintainer "ravi2523096@gmail.com"

EXPOSE 8080
VOLUME ["/usr/src", "/usr/src/myapp"]
ADD target/online-bank-0.0.1-SNAPSHOT.jar /usr/src/myapp/online-bank-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /usr/src/myapp/online-bank-0.0.1-SNAPSHOT.jar'
WORKDIR /usr/src/myapp
ENTRYPOINT ["java","-jar","online-bank-0.0.1-SNAPSHOT.jar"]
