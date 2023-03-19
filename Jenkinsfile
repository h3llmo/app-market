pipeline {
  agent {
    docker {
      image 'maven:3.8.3-openjdk-17'
      args '--add-host damosoft.internal.com:10.0.2.3'
    }

  }
  stages {
    stage('prepare') {
      steps {
        sh '/media/dtech/maven-settings/settings.xml ${WORKSPACE}/settings.xml"'
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