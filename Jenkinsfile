def remote = [:]
            remote.name = 'lawliet'
            remote.host = '192.168.32.128'
            remote.password = 'L.lawliet'
            remote.allowAnyHosts = true
pipeline{
    agent any
    
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
 


        