pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install' // Ou o comando de build do seu projeto
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean test -Dsurefire.suiteXmlFiles=resources/suites/Login_Suite.xml'
                // Ajuste os caminhos para as bibliotecas, classes e arquivo XML conforme necessário
            }
            post {
                always {
                    // Publicar os resultados dos testes
                    publishTestNGResults pattern: '**/surefire-reports/testng-results.xml'
                }
            }
        }
    }
}