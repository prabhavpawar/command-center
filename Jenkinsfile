pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'building command-center'
      }
    }

    stage('deploy') {
      steps {
        echo 'Deploy this on local or on aws'
      }
    }

  }
  environment {
    env = 'local,aws'
  }
}