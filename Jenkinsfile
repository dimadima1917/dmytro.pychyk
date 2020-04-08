pipeline {
    agent any

    parameters {
            booleanParam(defaultValue: true, description: '', name: 'userFlag')
    }

    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE    = 'sqlite'
    }

    stages {
        stage('Build') {
            steps {
                sh 'printenv'
            }
        }
    }
}
