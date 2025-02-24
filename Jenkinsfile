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

    environment {
        ALLURE_RESULTS_DIR = 'target/allure-results'
        TEST_SUITE = 'suites/Login_Suite.xml'  // Caminho da suíte de testes
    }

    stages {
        stage('Checkout Código') {
            steps {
                git 'https://github.com/SamuelSiq84/ProjetoAutomacaoExercise'  // Substitua pelo seu repositório
            }
        }

        stage('Compilar Projeto') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Executar Testes') {
            steps {
                sh "mvn test -Dsurefire.suiteXmlFiles=${TEST_SUITE}"
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
