[![Build Status](https://travis-ci.org/ravikalla/online-bank.svg?branch=master)](https://travis-ci.org/ravikalla/online-bank)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0c86bf7890ad417da8f08843204e8597)](https://www.codacy.com/app/ravikalla/online-bank?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ravikalla/online-bank&amp;utm_campaign=Badge_Grade)
[![Code Coverage](https://codecov.io/github/ravikalla/online-bank/coverage.svg)](https://codecov.io/gh/ravikalla/online-bank)
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

## Deployment Steps on Docker:
###### Download application
```
git clone https://github.com/ravikalla/online-bank.git
```
###### Start MySQL Docker Container
```
docker run --detach --name=bankmysql --env="MYSQL_ROOT_PASSWORD=root" -p 3306:3306 mysql:5.7.22
```
###### Execute SQL scripts in MySQL
```
cd online-bank
docker exec -i bankmysql mysql -uroot -proot < sql_dump/onlinebanking.sql
```
###### Run Docker image of the application
```
docker run --detach -p 8888:8888 --link bankmysql:localhost -t ravikalla/online-bank:latest
```
Access the application by clicking the URL "[http://localhost:8888!](http://localhost:8888)"

## Deployment Steps without Docker:
###### Build application
```
mvn clean build
```
###### DB Setup
 * Start [MySQL server!](https://dev.mysql.com/downloads/mysql/)
 * Use [MySQLWorkbench!](https://www.mysql.com/products/workbench/)
 * Run [SQL scripts!](https://github.com/ravikalla/online-bank/blob/master/sql_dump/onlinebanking.sql) in MySQL database

###### Run application
```
java -jar target/online-bank-0.0.1-SNAPSHOT.jar
```

## Things to know:
###### Build Docker image for the application
```
docker build -t ravikalla/online-bank:latest .
```
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
###### Start Jenkins Server on Docker
```
docker run --detach -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):$(which docker) -p 9080:8080 -p 50000:50000 -v /jenkins_bkp/jenkins_home:/var/jenkins_home ravikalla/jenkins-maven-docker:v0.1
```
###### Setup "online-bank" project in Jenkins:
 * Login to Jenkins and setup a pipeline project with source code from [Link to OnlineBank GIT repo!](https://github.com/ravikalla/online-bank.git)
 * Run the job to build and deploy the application

###### Debug H2 DB while testing
 * Set a debug point in any test step and check the URL "http://localhost:8888/console" while testing

## Code Quality Reports - ([wiki](https://github.com/ravikalla/online-bank/wiki/Host-Latest-Test-CodeQuality-Reports-Online))
For Online-Bank application, build happens in [TravisCI](https://travis-ci.org/ravikalla/online-bank) ![Build Status](https://travis-ci.org/ravikalla/online-bank.svg?branch=master) and the test reports are generated in the same TravisCI server during the build process.

We are generating Cucumber test results in "[ExtentReport](http://extentreports.com)" format. Extent Reports are open source and provides very good visuals for test reports - [sample Extent report](http://extentreports.com/samples/extent-bdd.html).

In the file [.travis.yml](https://github.com/ravikalla/online-bank/blob/master/.travis.yml#L14), it is configured to push the generated test reports to "[gh-pages](https://github.com/ravikalla/online-bank/tree/gh-pages)" branch once the build is complete.

Once these test reports are uploaded to "[gh-pages](https://github.com/ravikalla/online-bank/tree/gh-pages)" branch in [Online-Bank](https://github.com/ravikalla/online-bank) project, you can access various reports online using below links -

1. Cucumber Native Test Results - [https://ravikalla.github.io/online-bank/cucumber/cucumber-html-report](https://ravikalla.github.io/online-bank/cucumber/cucumber-html-report)

<img src="https://github.com/ravikalla/images/blob/master/online-bank/CucumberReport.png" width="50%" height="50%">

2. Extent Report that has Cucumber Test Results - [https://ravikalla.github.io/online-bank/extent-report.html](https://ravikalla.github.io/online-bank/extent-report.html)

<img src="https://github.com/ravikalla/images/blob/master/online-bank/ExtentReport1.png" width="50%" height="50%">

<img src="https://github.com/ravikalla/images/blob/master/online-bank/ExtentReport2.png" width="50%" height="50%">

<img src="https://github.com/ravikalla/images/blob/master/online-bank/ExtentReport3.png" width="50%" height="50%">

3. JaCoCo Report for code coverage - [https://ravikalla.github.io/online-bank/site/jacoco](https://ravikalla.github.io/online-bank/site/jacoco)

<img src="https://github.com/ravikalla/images/blob/master/online-bank/JaCoCoReport.png" width="80%" height="80%">
