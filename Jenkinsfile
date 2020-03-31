pipeline {
    tools { 
        maven 'Maven 3.6.3' 
        jdk 'jdk8' 
    }
    stage('Checkout') {
            git 'https://github.com/TheGreatMed/angularTest.git'  
    }

    stage('clean project'){
        bat 'cd crud-angular'
        bat 'mvn --version'

    }
    
}
        