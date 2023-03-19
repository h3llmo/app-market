def dockerTag = "0.0";
def image;
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
        script {
            dockerTag = sh(returnStdout: true, script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout')
        }
        junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
      }
    }

    stage('Docker Build') {
      steps {
        script {
          image = docker.build(env.APP_IMAGE + ':' + dockerTag, "-f src/main/docker/Dockerfile.jvm --pull .")
        }
      }
    }
    stage('Push Registry') {
      steps {
        script {
            docker.withRegistry("http://damosoft.internal.com:1100", "docker-credentials") {
                image.push()
            }
        }
      }
    }    
  }
  environment {
    APP_NAME="app-market"
    APP_IMAGE="damosoft/app-market"      
    NEXUS_HOST="damosoft.internal.com"
    NEXUS_IP="10.0.2.3"
    MAVEN_IMAGE="maven:3.8.3-openjdk-17"
    MAVEN_SETTINGS="/home/jenkins_home/.m2/settings.xml"
  }
}
