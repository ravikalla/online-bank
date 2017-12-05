pipeline {
    agent any 

    stages {
        stage('Checkout') { 
            steps { 
               echo 'checking out'
               checkout scm
            }
        }
        stage('Build'){
            steps {
                echo 'Building...'
                mvn clean package
            }
        }
        stage('Deploy') {
            steps {
                echo 'make publish'
            }
        }
    }
}
