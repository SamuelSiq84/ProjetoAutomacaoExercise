pipeline {
    agent any

    environment{
        ALLURE_RESULTS_DIR = "target/allure-results"
        TEST_SUITE = "src/test/java/suites/Login_Suite.xml"
    }

   stages {

        stage('Executar Testes') {
            steps {
                sh "/opt/homebrew/bin/mvn test -Dsurefire.suiteXmlFiles=${TEST_SUITE}"

            }
        }

        stage('Publicar Relatórios') {
            steps {
                script {
                    allure([
                        results: [[path: ALLURE_RESULTS_DIR]]
                    ])
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
