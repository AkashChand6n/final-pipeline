pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/KPkm25/java_microservices.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                sh 'mvn sonar:sonar'
            }
        }

        stage('Docker Build and Push') {
            steps {
                sh 'docker build -t akashchandran/java-microservice .'
                sh 'docker push akashchandran/java-microservice'
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }
    }
}

