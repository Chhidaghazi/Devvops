pipeline {
    agent any

	environment {

		   registry = "ghazichhida/ExamThourayaS2"

        registryCredential = 'dockerhub'

        dockerImage = ''

        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.16.203:8081"
        NEXUS_REPOSITORY = "maven-releases"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
    }


    stages {
        stage('Checkout Git') {
            steps {
                echo 'Pulling ...';
                git branch : 'main',
                // Get some code from a GitHub repository
                url: 'https://github.com/Chhidaghazi/Devvops.git'


            }
        }


        stage("Maven Build") {
            steps {
                script {
                    sh "mvn clean install -DskipTests"
                }
            }
        }

        stage('MVN COMPILE') {
            steps {
               sh' mvn compile'

            }
         }

		  stage("Unit tests") {
            steps {
                  sh "mvn test"
            }
         }

         stage('MVN SONARQUBE') {
                     steps {
                         sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                     }
                 }

  stage('NexuS  ')
 {
  steps{
        echo "nexus"
        sh 'mvn clean '
       sh ' mvn deploy -DskipTests'
         }
       }

// 		stage("Publish to Nexus Repository Manager") {
//             steps {
//                 script {
//                     pom = readMavenPom file: "pom.xml";
//                     filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
//                     echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
//                     artifactPath = filesByGlob[0].path;
//                     artifactExists = fileExists artifactPath;
//                     if(artifactExists) {
//                         echo "* File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
//                         nexusArtifactUploader(
//                             nexusVersion: NEXUS_VERSION,
//                             protocol: NEXUS_PROTOCOL,
//                             nexusUrl: NEXUS_URL,
//                             groupId: pom.groupId,
//                             version: pom.version,
//                             repository: NEXUS_REPOSITORY,
//                             credentialsId: NEXUS_CREDENTIAL_ID,
//                             artifacts: [
//                                 [artifactId: pom.artifactId,
//                                 classifier: '',
//                                 file: artifactPath,
//                                 type: pom.packaging],
//                                 [artifactId: pom.artifactId,
//                                 classifier: '',
//                                 file: "pom.xml",
//                                 type: "pom"]
//                             ]
//                         );
//                     } else {
//                         error "* File: ${artifactPath}, could not be found";
//                     }
//                 }
//             }
//         }
//
//                      stage('Building our image') {
//                   			steps {
//                   				script {
//                   					dockerImage = docker.build registry + ":$BUILD_NUMBER"
//                   					}
//                   				}
//                   		}
//
//
//
//
//
//
//
// 	    stage('Deploy our image') {
//                            steps {
//                            script {
//                                docker.withRegistry( '', registryCredential ) {
//                                dockerImage.push()
//                                  }
//                               }
//                             }
//
//                           }
//
//  stage       ('DOCKER COMPOSE') {
//              steps {
//                 sh 'docker-compose up -d '
//             }
//         }




    }

}
