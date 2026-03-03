pipeline {
  agent {
    docker {
      image 'maven:3.9.9-eclipse-temurin-17'
      args '-v /var/run/docker.sock:/var/run/docker.sock'
    }
  }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build & Test') {
      steps {
        sh 'mvn -v'
        sh 'mvn clean test'
        sh 'mvn package -DskipTests'
      }
    }

    stage('JaCoCo Report') {
      steps {
        // Your pom already generates target/site/jacoco
        archiveArtifacts artifacts: 'target/site/jacoco/**/*', fingerprint: true
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