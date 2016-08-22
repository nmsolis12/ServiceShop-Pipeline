node {
   stage 'Clean Workspace'
   deleteDir()
   
   stage 'Git Clone'
   git credentialsId: 'a73dc1e8-4416-4d00-a306-354c4c7037fe', url: 'git@github.com:nmsolis12/ServiceShop.git'
   
   stage 'Maven Build'
   env.MAVEN_HOME = "${tool 'maven-3.3.9'}"
   env.JAVA_HOME="${tool 'jdk-8u102'}"
   env.PATH="${env.MAVEN_HOME}/bin;${env.JAVA_HOME}/bin;${env.PATH}"
   
   echo 'Hello'
   bat 'mvn clean install'
}
