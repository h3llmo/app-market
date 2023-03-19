pipeline {
  agent any
  stages {
    stage('build') {
      agent {
        docker {
          image 'maven:3.8.3-openjdk-17'
          args '''-v /media/dtech/maven-settings:/opt/maven -w /opt/maven
--add-host damosoft.internal.com:10.0.2.3'''
        }

      }
      steps {
        sh 'mvn clean package -s /opt/maven/settings.xml'
        sh '''script {
            dockerTag = sh(returnStdout: true, script: \'mvn help:evaluate -Dexpression=project.version -q -DforceStdout\')
        }'''
        }
      }

      stage('docker-build') {
        steps {
          sh 'image = docker.build(\'damosoft/app-market:\' + dockerTag, "-f src/main/docker/Dockerfile.jvm --pull .")'
        }
      }

      stage('docker-push') {
        steps {
          sh '''docker.withRegistry("http://damosoft.internal.com:1100", "docker-credentials") {
            image.push()
}'''
          }
        }

      }
    }