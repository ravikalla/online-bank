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
        stage('Build and Run Docker') {
            steps {
                echo 'Building Docker image'
                sh 'docker build -t online-bank .'
            }
        }
    }
}
