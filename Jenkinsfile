def remote = [:]
            remote.name = 'lawliet'
            remote.host = '192.168.32.128'
            remote.user = 'lawliet'
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
           dir('crud-angular'){
                bat 'mvn clean'
              }
        }
       }
       stage('clean build'){
       steps{  
           dir('crud-angular'){
                bat 'mvn install'
            }
        }
       }
       stage('clean-build-angular'){
           steps{
               dir('angular-crud'){
               bat 'npm install'
               bat 'npm run build'
           }
           }
       }
       stage('clean deploy'){
       steps{  
           dir('crud-angular'){
                bat 'mvn deploy --settings settings.xml -Dmaven.test.skip=true'
            }
             sshCommand remote: remote, command: "cd ~/Desktop/test", command: "ansible-playbook playbook1.yml"
                      
        }
       }

     }
  }
 


        