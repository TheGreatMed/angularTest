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
               bat 'npm install --prefix ./node_modules copyfiles -g --save'
               bat 'npm run build'
           }
           }
       }
       stage('clean deploy'){
       steps{  
           dir('crud-angular'){
                bat 'mvn deploy --settings settings.xml -Dmaven.test.skip=true'
                dir('target'){
                    bat 'copy crud.war C:\\apache-tomcat-9.0.31\webapps\'
                }
            }
        }
       }

     }
  }
 


        