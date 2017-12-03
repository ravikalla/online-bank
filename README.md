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

#### DB Setup:
 * docker network create --driver bridge cloudbank_network
 * docker run --detach --name=onlinebanking --net=cloudbank_network --env="MYSQL_ROOT_PASSWORD=root" -p 3306:3306 mysql
 * Run "sql_dump/onlinebanking.sql" in above SQL server. (I recomend "MySQLWorkbench" as IDE)
#### Application Build and Start:
 * cd online-bank
 * mvn clean install
 * java -jar target/cloudbank-0.0.1-SNAPSHOT.jar
#### Application Build and Start using Docker:
 * docker build -t ravikalla/cloudbank:v0.1 .
 * docker run -p 8080:8080 --net=cloudbank_network -v /Users/ravi_kalla/Desktop/Projects/online-bank/src/main/resources:/usr/src -t ravikalla/cloudbank:v0.1

#### Debug H2 DB while testing
 * Set a debug point in any test step and check the URL "http://localhost:8080/console" while testing