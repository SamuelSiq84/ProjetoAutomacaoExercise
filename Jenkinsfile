pipeline {
    agent any
    triggers {
          cron '''TZ=America/Sao_Paulo
        @hourly'''
        }

   stages {

        stage('Executar Testes') {
            steps {
                sh "/opt/homebrew/bin/mvn test -Dsurefire.suiteXmlFiles=src/test/java/suites/Login_Suite.xml"

            }
        }

//         stage('Publicar Relatórios') {
//             steps {
//                 script {
//
//                         allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
//
//                 }
//             }
//         }
    }

    post {

            allure includeProperties:
             false,
             jdk: '',
             results: [[path: 'build/allure-results']]

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
