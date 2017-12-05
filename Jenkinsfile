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
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'make publish'
            }
        }
    }
}
