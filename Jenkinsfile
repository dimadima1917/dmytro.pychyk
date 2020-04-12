node {
    parameters {
        String(name: 'DEFAULT_BRANCH', defaultValue: '', description: '')
    }
    stage('Pulling source code') {
        dir('source-code') {           
            git(url: 'https://github.com/dimadima1917/dmytro.pychyk.git', credentialsId: '5a1238a0-fd9d-40dc-bc8c-a81376ab65b8', branch: "master", returnStdOut: true)
        }
        dir('test') {               
            git(url: 'https://github.com/dimadima1917/dmytro.pychyk.git', credentialsId: '5a1238a0-fd9d-40dc-bc8c-a81376ab65b8', branch: "master", returnStdOut: true)
        }
    }
}

//def getBranchName(repository) {
//    script {
//        if (paramIsEmpty) {
//            return 'master'
//        }
//        def jobName = sh script: 'echo ', returnStdout: true
//    }
//}