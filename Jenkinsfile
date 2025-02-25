pipeline {
    agent any

    stages {

        stage('Executar Testes') {
            steps {
                sh "/opt/homebrew/bin/mvn test -Dsurefire.suiteXmlFiles=src/test/java/suites/Login_Suite.xml"

            }
        }

//                 stage('Publicar Relatórios') {
//                     steps {
//                         script {
//
//                                 allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
//
//                         }
//                     }
//                 }
    }

    post {
        always {
            allure includeProperties:
             false,
             jdk: '',
             results: [[path: 'build/allure-results']]
        }
    }
}
