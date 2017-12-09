pipeline {
    agent any 
    stages {
        stage ("initialize") {
         steps {
            sh '''
            echo "PATH = ${PATH}"
            echo "M2_HOME = ${M2_HOME}"
            '''
         }
        }
        stage('Checkout') { 
            steps { 
               echo 'checking out'
               checkout scm
            }
        }
        stage('Build'){
            steps {
                echo 'Building...'
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('Build Docker') {
            steps {
                echo 'Building Docker image'
                sh 'docker build -t ravikalla/cloudbank:v0.1 .'
            }
        }
       stage('Create database ') {
            steps {
                echo 'Running Database Image'
            //    sh 'docker kill bankmysql 2> /dev/null'
            //    sh 'docker kill cloudbank 2> /dev/null'
            //    sh 'docker rm bankmysql 2> /dev/null'
            //    sh 'docker rm cloudbank 2> /dev/null'
                sh 'docker stop bankmysql || true && docker rm bankmysql || true'
                sh 'docker run --detach --name=bankmysql --env="MYSQL_ROOT_PASSWORD=root" -p 3306:3306 mysql'
                sh 'sleep 10'
                sh 'docker exec -i bankmysql mysql -uroot -proot < sql_dump/onlinebanking.sql'
            }
        }
        stage('Run') {
            steps {
                echo 'Running Application'
                sh 'docker stop cloudbank || true && docker rm cloudbank || true'
                sh 'docker run --detach --name=cloudbank -p 8080:8080 --link bankmysql:dbhost -t ravikalla/cloudbank:v0.1'
            }
        }
    }
}
