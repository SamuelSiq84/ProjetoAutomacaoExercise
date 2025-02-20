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

        stage('Run Tests') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Generate Reports') {
            steps {
                script {
                    sh 'mvn surefire-report:report'
                }
            }
        }

        stage('Publish Reports') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site',
                    reportFiles: 'surefire-report.html',
                    reportName: 'Test Report'
                ])
            }
        }

        stage('Post Actions') {
            steps {
                script {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo 'Testes executados com sucesso!'
        }
        failure {
            echo 'Os testes falharam!'
        }
    }
}
