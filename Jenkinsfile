pipeline {
  agent {
    docker {
      image 'maven:3.8.3-openjdk-17'
      args '--add-host ${NEXUS_HOST}:${NEXUS_IP}'
    }

  }
  stages {
    stage('prepare') {
      steps {
        sh 'sh "cp ${env.MAVEN_SETTINGS} ${WORKSPACE}/settings.xml"'
      }
    }

    stage('build') {
      steps {
        sh 'sh "mvn clean package"'
      }
    }

  }
  environment {
    NEXUS_HOST = 'damosoft.internal.com'
    NEXUS_IP = '10.0.2.3'
  }
}