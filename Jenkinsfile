// pipeline {
//     agent any
//
//     stages {
//         stage('Checkout') {
//             steps {
//                 checkout scm
//             }
//         }
//
//         stage('Test') {
//             steps {
//                 sh 'java -cp ".:lib/*:target/classes:target/test-classes" org.testng.TestNG src/test/suites/Login_Suite.xml'
//                 // Ajuste os caminhos para as bibliotecas, classes e arquivo XML conforme necessário
//             }
//             post {
//                 always {
//                     // Publicar os resultados dos testes
//                     publishTestNGResults pattern: '**/surefire-reports/testng-results.xml'
//                 }
//             }
//         }
//     }
// }
pipeline {
    agent any

   stages {

        stage('Executar Testes') {
            steps {
                sh "/opt/homebrew/bin/mvn test -Dsurefire.suiteXmlFiles=src/test/suites/Login_Suite.xml"

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
