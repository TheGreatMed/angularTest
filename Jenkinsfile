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
   }
    
}
        