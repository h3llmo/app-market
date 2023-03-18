def dockerTag = "0.0";
def image;
pipeline {
  agent any

  options {
    disableConcurrentBuilds()
  }
  
  environment {
    APP_NAME="app-market"
    APP_IMAGE="damosoft/app-market"      
    NEXUS_HOST="damosoft.internal.com"
    NEXUS_IP="10.0.2.3"
    MAVEN_IMAGE="maven:3.8.3-openjdk-17"
    MAVEN_SETTINGS="/home/jenkins_home/.m2/settings.xml"
  }

  stages {

    stage ('checkout') {
      steps {
        checkout changelog: false, scm: scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/h3llmo/app-market.git']])
        sh "cp ${env.MAVEN_SETTINGS} ${WORKSPACE}/settings.xml"
      }
    }

    stage ('build') {
      agent {
        docker reuseNode: true, image: "maven:3.8.3-openjdk-17", args: "--add-host ${NEXUS_HOST}:${NEXUS_IP}"
      }
      steps {
        sh "mvn clean package --settings ${WORKSPACE}/settings.xml"
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
}
