pipeline{
    agent any
    def remote = [:]
            remote.name = 'lawliet'
            remote.host = 'lawliet@192.168.32.128'
            remote.user = 'lawliet'
            remote.password = 'L.lawliet'
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
 


        