pipeline {
    agent any

    stages {

        stage('Executar Testes') {
            steps {
                sh "/opt/homebrew/bin/mvn test -Dsurefire.suiteXmlFiles=src/test/java/suites/Login_Suite.xml"

            }
        }

        stage('Publicar Relatórios') {
            steps {
                script {

                        allure includeProperties: false, jdk: '', results: [[path: '$WORKSPACE/target/allure_results']]

                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finalizado!'
        }
        success {
            echo 'Testes passaram com sucesso!'
        }
        failure {
            echo 'Testes falharam!'
        }
    }
}
