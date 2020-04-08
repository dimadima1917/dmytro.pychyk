pipeline {
    agent any

    parameters {
            listGitBranches(name: 'branches', remoteURL: 'https://github.com/dimadima1917/dmytro.pychyk.git')
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
