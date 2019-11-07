pipeline{
 
		agent {
			label 'Slave_Induccion'
		}


		triggers {
			pollSCM('@hourly')
		}

		options {
			buildDiscarder(logRotator(numToKeepStr:'5'))
			disableConcurrentBuilds()
		}
		
		tools{
			jdk 'JDK8_Centos'
			gradle 'Gradle5.6_Centos'
		}

		stages {

			stage('Checkout Git'){
				steps{
				   checkout([
				   $class: 'GitSCM', 
				   branches: [[name: '*/master']], 
				   doGenerateSubmoduleConfigurations: false, 
				   extensions: [], 
				   gitTool: 'Git_Centos', 
				   submoduleCfg: [], 
			userRemoteConfigs: [[
						credentialsId: 'GitHub_jhonlara', 
						url: 'https://github.com/JhonLara/Urgencias.git'
						]]])
				}
			}
			 
			stage('Build project') { 
			   steps { 
					sh 'gradle --b ./Urgencias-Back/build.gradle clean'
					sh 'gradle --b ./Urgencias-Back/build.gradle build'
				}
			}

			stage('Unit Test & Coverage') {
				steps {
				    sh 'gradle --b ./Urgencias-Back/build.gradle test'
				    sh 'gradle --b ./Urgencias-Back/build.gradle jacocoTestReport'
				}
			}          
			
			stage('Integration Tests') {
           	steps {
               echo "------------>Integration Tests<------------"
           	}
      		}
       
			stage('Static Code Analysis') {
			steps{
				echo "------------>Sonar<------------"
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties"
				}
			}
		}

		}
    
		post { 
			failure { 
				mail( to: 'andres.buitrago@ceiba.com.co' ,
					body: "Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/n Please go to ${env.BUILD_URL} and verify the build", 
					subject: "ERROR CI: Project name → ${env.JOB_NAME}")
            } 
        }
    }  
	