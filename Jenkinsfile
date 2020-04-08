pipeline {
    agent any

    parameters {
            string(defaultValue: getBranchName(), description: '', name: 'userFlag')
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

def getBranchName() {
    script {
        def branchName = sh script: 'echo branchName'
        return branchName
    }
}
