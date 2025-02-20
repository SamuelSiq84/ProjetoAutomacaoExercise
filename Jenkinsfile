pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.repo.local=.m2/repository"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'feature_refactory', url: 'https://github.com/SamuelSiq84/ProjetoAutomacaoExercise.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Run TestNG Tests') {
            steps {
                script {
                    sh 'mvn test -Dsurefire.suiteXmlFiles=testng.xml'
                }
            }
        }

        stage('Generate Test Reports') {
            steps {
                script {
                    sh 'mvn surefire-report:report'
                }
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/testng-results.xml'
            }
        }

        stage('Publish HTML Reports') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report'
                ])
            }
        }
    }

    post {
        success {
            echo 'Testes do TestNG executados com sucesso!'
        }
        failure {
            echo 'Falha nos testes do TestNG!'
        }
    }
}
