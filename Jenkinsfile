pipeline {
	agent any
    	tools {
        	maven 'Maven 3.6.1'
        	jdk 'jdk8'
	}
	stages {
		stage('Test') {
			steps {
				sh 'mvn clean package'
			}
		}
	}
}
