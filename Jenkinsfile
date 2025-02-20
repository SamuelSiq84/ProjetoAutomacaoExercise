pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'feature_refactory', url: 'https://github.com/SamuelSiq84/ProjetoAutomacaoExercise.git'
            }
        }

        stage('Build') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }

        stage('Testes com Allure') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn test allure:report"
            }
        }

        stage('Publicar Allure Report') {
            steps {
                allure([
                    results: [[path: 'target/allure-results']]
                ])
            }
        }

        stage('Armazenar Artefato') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build e testes concluídos com sucesso!'
        }
        failure {
            echo 'Ocorreu um erro no pipeline.'
        }
    }
}
