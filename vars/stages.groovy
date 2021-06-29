def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn clean sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn clean deploy"
     }
  else if ("${stageName}" == "Tomcat")
     {
       sshagent(['0b893714-8365-4da2-af34-6da4c63331db']){
	sh "scp -o StrictHostKeyChecking=no target/maven-web-application.war ec2-user@13.126.141.188:/opt/apache-tomcat-9.0.46/webapps"
	}
     }
}
