node{
    stage('Checkout') {
            git 'https://github.com/TheGreatMed/angularTest.git'  
    }

    stage('clean project'){
        bat 'cd crud-angular'
        bat 'dir'
        sh 'mvn --version'

    }
    
}
        