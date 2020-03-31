def remote = [:]
            remote.name = 'lawliet'
            remote.host = '192.168.32.128'
            remote.allowAnyHosts = true
pipeline{
    agent any
    withCredentials([usernamePassword(credentialsId: 'lawliet', passwordVariable: 'L.lawliet', usernameVariable: 'lawliet')]) 
        remote.user = lawliet
        remote.password = L.lawliet
    
   stages{
        stage('Checkout') {
            steps{
                git 'https://github.com/TheGreatMed/angularTest.git'  
            }
        }
   
    stage('clean project'){
       steps{  
            sshCommand remote: remote, command: "ls"           
        }
       }
       

     }
  }
 


        