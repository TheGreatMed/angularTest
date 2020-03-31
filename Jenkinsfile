pipeline{
    agent any
   stages{
        stage('Checkout') {
            steps{
                git 'https://github.com/TheGreatMed/angularTest.git'  
            }
    }
   dir('crud-angular'){
    stage('clean project'){
       steps{
           
                bat 'mvn clean'
            }
       }

    }
    }
   }
    
}
        