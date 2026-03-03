pipeline {
  agent any

  stages {
    stage('Build + Test') {
      agent {
        docker {
          image 'maven:3.9.9-eclipse-temurin-17'
          args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
      }
      steps {
        sh 'mvn -v'
        sh 'mvn clean test'
        sh 'mvn package -DskipTests'
      }
    }

    stage('JaCoCo Report') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Build Docker Image') {
      steps {
        sh 'docker version'
        sh 'docker build -t temp-converter:latest .'
      }
    }
  }
}