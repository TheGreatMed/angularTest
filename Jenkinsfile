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
            bat 'cd crud-angular'
            bat 'dir'
            bat 'mvn --version'
       }

    }
   }
    
}
        