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
       stage('clean buil'){
       steps{  
           dir('crud-angular'){
                bat 'mvn install'
              }
        }
       }
       stage('clean deploy'){
       steps{  
           dir('crud-angular'){
                bat 'mvn deploy --settings settings.xml -Dmaven.test.skip=true'
            }
        }
       }

       stage('insstal'){
           steps{
           ansiblePlaybook(credentialsId: 'lawliet ', inventory: 'hosts.ini', playbook: 'playbook.yml')
           }
       }  

     }
  }
 


        