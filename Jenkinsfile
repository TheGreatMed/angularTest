def remote = [:]
            remote.name = 'lawliet'
            remote.host = '192.168.32.128'
            remote.user = 'root'
            remote.password = 'L.lawliet'
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
 


        