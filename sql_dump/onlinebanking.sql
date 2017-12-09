CREATE DATABASE  IF NOT EXISTS `onlinebanking`;
USE onlinebanking;

DROP TABLE IF EXISTS primary_account;
CREATE TABLE primary_account (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  account_balance decimal(19,2) DEFAULT NULL,
  account_number int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES primary_account WRITE;
INSERT INTO primary_account VALUES (1,1700.00,11223146),(3,0.00,11223150);
UNLOCK TABLES;

DROP TABLE IF EXISTS savings_account;
CREATE TABLE savings_account (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  account_balance decimal(19,2) DEFAULT NULL,
  account_number int(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES savings_account WRITE;
INSERT INTO savings_account VALUES (1,4250.00,11223147),(3,0.00,11223151);
UNLOCK TABLES;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  enabled bit(1) NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  primary_account_id bigint(20) DEFAULT NULL,
  savings_account_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY UK_ob8kqyqqgmefl0aco34akdtpe (email),
  KEY FKbj0uoj9i40dory8w4t5ojyb9n (primary_account_id),
  KEY FKihums7d3g5cv9ehminfs1539e (savings_account_id),
  CONSTRAINT FKbj0uoj9i40dory8w4t5ojyb9n FOREIGN KEY (primary_account_id) REFERENCES primary_account (id),
  CONSTRAINT FKihums7d3g5cv9ehminfs1539e FOREIGN KEY (savings_account_id) REFERENCES savings_account (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES user WRITE;
INSERT INTO user VALUES (1,'dleskov@gmail.ru','','Dmitry','Leskov','$2a$12$DWCryEwHwbTYCegib92tk.VST.GG1i2WAqfaSwyMdxX0cl0eBeSve','5551112345','User',1,1),(3,'asd@gmail.com','','alex','osipov','$2a$12$hZR7pcSf0JU/OTXR3TOyuu8r6C6n.JZE8Ei47E4LZs1t0Aq1AO6oC','1111111111','Admin',3,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS appointment;
CREATE TABLE appointment (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  confirmed bit(1) NOT NULL,
  date datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  location varchar(255) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKa8m1smlfsc8kkjn2t6wpdmysk (user_id),
  CONSTRAINT FKa8m1smlfsc8kkjn2t6wpdmysk FOREIGN KEY (user_id) REFERENCES user (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES appointment WRITE;

INSERT INTO appointment VALUES (1,'','2017-01-25 14:01:00','Want to see someone','Helsinki',1),(2,'\0','2017-01-30 15:01:00','Take credit','Helsinki',1),(3,'','2017-02-16 15:02:00','Consultation','Helsinki',1);

UNLOCK TABLES;

DROP TABLE IF EXISTS primary_transaction;
CREATE TABLE primary_transaction (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  amount double NOT NULL,
  available_balance decimal(19,2) DEFAULT NULL,
  date datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  primary_account_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK643wtfdx6y0e093wlc09csehn (primary_account_id),
  CONSTRAINT FK643wtfdx6y0e093wlc09csehn FOREIGN KEY (primary_account_id) REFERENCES primary_account (id)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

LOCK TABLES primary_transaction WRITE;
INSERT INTO primary_transaction VALUES (1,5000,5000.00,'2017-01-13 00:57:16','Deposit to Primary Account','Finished','Account',1),(2,1500,3500.00,'2017-01-13 00:57:31','Withdraw from Primary Account','Finished','Account',1),(3,1300,2200.00,'2017-01-13 00:58:03','Between account transfer from Primary to Savings','Finished','Account',1),(4,500,1700.00,'2017-01-13 00:59:08','Transfer to recipient Mr. Tomson','Finished','Transfer',1),(5,1500,3200.00,'2017-01-13 01:11:38','Deposit to Primary Account','Finished','Account',1),(6,400,2800.00,'2017-01-13 01:11:46','Withdraw from Primary Account','Finished','Account',1),(7,2300,2000.00,'2017-01-13 01:13:48','Between account transfer from Primary to Savings','Finished','Account',1),(8,300,1700.00,'2017-01-13 01:14:14','Transfer to recipient TaxSystem','Finished','Transfer',1);
UNLOCK TABLES;

DROP TABLE IF EXISTS recipient;
CREATE TABLE recipient (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  account_number varchar(255) DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK3041ks22uyyuuw441k5671ah9 (user_id),
  CONSTRAINT FK3041ks22uyyuuw441k5671ah9 FOREIGN KEY (user_id) REFERENCES user (user_id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES recipient WRITE;
INSERT INTO recipient VALUES (1,'213425635454','Rent payment','tomson@gmail.com','Mr. Tomson','1112223333',1),(2,'453452341324','Gym payment','fitness@gmail.com','LtdFitness','323245345',1),(3,'5465464234542','Tax payment 20%','taxes@mail.fi','TaxSystem','34254353',1);
UNLOCK TABLES;

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  role_id int(11) NOT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES role WRITE;
INSERT INTO role VALUES (0,'ROLE_USER'),(1,'ROLE_ADMIN');
UNLOCK TABLES;

DROP TABLE IF EXISTS savings_transaction;
CREATE TABLE savings_transaction (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  amount double NOT NULL,
  available_balance decimal(19,2) DEFAULT NULL,
  date datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  savings_account_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK4bt1l2090882974glyn79q2s9 (savings_account_id),
  CONSTRAINT FK4bt1l2090882974glyn79q2s9 FOREIGN KEY (savings_account_id) REFERENCES savings_account (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

LOCK TABLES savings_transaction WRITE;
INSERT INTO savings_transaction VALUES (1,1000,1000.00,'2017-01-13 00:57:40','Deposit to savings Account','Finished','Account',1),(2,150,2150.00,'2017-01-13 01:11:15','Withdraw from savings Account','Finished','Account',1),(3,400,1750.00,'2017-01-13 01:11:23','Withdraw from savings Account','Finished','Account',1),(4,2000,3750.00,'2017-01-13 01:11:30','Deposit to savings Account','Finished','Account',1),(5,1500,2250.00,'2017-01-13 01:13:38','Between account transfer from Savings to Primary','Finished','Transfer',1),(6,300,4250.00,'2017-01-13 01:14:02','Transfer to recipient LtdFitness','Finished','Transfer',1);
UNLOCK TABLES;

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  user_role_id bigint(20) NOT NULL AUTO_INCREMENT,
  role_id int(11) DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (user_role_id),
  KEY FKa68196081fvovjhkek5m97n3y (role_id),
  KEY FK859n2jvi8ivhui0rl0esws6o (user_id),
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES user (user_id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES role (role_id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

LOCK TABLES user_role WRITE;
INSERT INTO user_role VALUES (1,0,1),(2,1,3);
UNLOCK TABLES;
