pipeline {
    agent any 

    stages {
        stage('Checkout') { 
            steps { 
               echo 'checking out'
               checkout scm
            }
        }
        stage('Run'){
            steps {
                echo 'Run'
            }
        }
        stage('Deploy') {
            steps {
                echo 'make publish'
            }
        }
    }
}
