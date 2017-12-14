[![Build Status](https://travis-ci.org/ravikalla/online-bank.svg?branch=master)](https://travis-ci.org/ravikalla/online-bank)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0c86bf7890ad417da8f08843204e8597)](https://www.codacy.com/app/ravikalla/online-bank?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ravikalla/online-bank&amp;utm_campaign=Badge_Grade)
[![Issue Count](https://codeclimate.com/github/ravikalla/online-bank/badges/issue_count.svg)](https://codeclimate.com/github/ravikalla/online-bank)
[![Issue Count](https://codeclimate.com/github/ravikalla/online-bank/badges/issue_count.svg)](https://codeclimate.com/github/ravikalla/online-bank)
[![Issues](https://img.shields.io/github/issues/ravikalla/online-bank.svg?style=flat-square)](https://github.com/ravikalla/online-bank/issues)
[![Docker Stars](https://img.shields.io/docker/stars/ravikalla/online-bank.svg)](https://hub.docker.com/r/ravikalla/online-bank/)
[![Docker Pull](https://img.shields.io/docker/pulls/ravikalla/online-bank.svg)](https://hub.docker.com/r/ravikalla/online-bank/)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Join the chat at https://gitter.im/online-bank-bdd/Lobby](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/online-bank-bdd/Lobby?utm_source=share-link&utm_medium=link&utm_campaign=share-link)

# Online Bank
Spring Boot/Spring Data/Spring Security/Hibernate/MySQL/REST

The project simulates online banking system. It allows to register/login, deposit/withdraw money from accounts, add/edit recipients,
transfer money between accounts and recipients, view transactions, make appointments.

There are two roles user and admin. 

The admin has there own fronent implemented in Angular2, which communicates with backend through REST services.

There is a sql dump with prepopulated data inside project folder. 
The username and password for database: root

You can login with:
User - password;
Admin - password

## Deployment Steps:

#### DB Setup using Docker:
###### Start MySQL Docker Container
```
docker run --detach --name=bankmysql --env="MYSQL_ROOT_PASSWORD=root" -p 3306:3306 mysql
```
###### Execute SQL scripts in MySQL
```
docker exec -i bankmysql mysql -uroot -proot < sql_dump/onlinebanking.sql
```
#### Application setup:
###### Clone application
```
git clone https://github.com/ravikalla/online-bank.git
```
###### Build application
```
cd online-bank
mvn clean install
```
###### Run application directly
```
java -jar target/online-bank-0.0.1-SNAPSHOT.jar
```
#### Application setup with Docker:
###### Build Docker image for the application
```
docker build -t ravikalla/online-bank:latest .
```
###### Run Docker image of the application
```
docker run --detach -p 8080:8080 --link bankmysql:localhost -t ravikalla/online-bank:latest
```
Access the application by clicking the URL "[http://localhost:8080!](http://localhost:8080)"
#### Application setup with Maven on Docker playground:
###### Create Jenkins image that has Maven
```
sudo chmod 777 /var/run/docker.sock && \
mkdir -p /jenkins_bkp/jenkins_home && \
chmod -R 777 /jenkins_bkp && \
git clone https://github.com/ravikalla/online-bank.git && \
cd online-bank && \
git checkout master && \
cp Dockerfile-Jenkins-Maven ../Dockerfile && \
cd .. && \
docker build -t ravikalla/jenkins-maven-docker:v0.1 .
```
###### Start Jenkins Image
```
docker run --detach -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):$(which docker) -p 9080:8080 -p 50000:50000 -v /jenkins_bkp/jenkins_home:/var/jenkins_home ravikalla/jenkins-maven-docker:v0.1
```
###### Setup project in Jenkins:
 * Login to Jenkins and setup a pipeline project with source code from [Link to OnlineBank GIT repo!](https://github.com/ravikalla/online-bank.git)
 * Run the job to build and deploy the application

#### Debug H2 DB while testing
 * Set a debug point in any test step and check the URL "http://localhost:8080/console" while testing
