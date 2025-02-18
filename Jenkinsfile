// If you use the [Declarative Pipeline syntax](https://www.jenkins.io/doc/book/pipeline/syntax/#declarative-pipeline), find the stage that runs the tests and insert a new `always` block into that stage's `post` block. This will make Allure Report run after the test launch regardless of how many tests succeeded.
pipeline {
    agent any
    tools{
        maven 'Maven 3.9.9'
        jdk 'jdk-23'
    }
    triggers {
      cron '''TZ=America/Sao_Paulo
    @hourly'''
    }
    stages {
        stage('Test'){
                steps{
                    sh
                    echo "PATH = ${PATH}"
                    echo "M3_HOME = ${M2_HOME}"
                }


            post {
                always {
                    allure includeProperties:
                     false,
                     jdk: '',
                     results: [[path: 'target/allure-results']]
                }
            }
        }
    }
}