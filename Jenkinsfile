node{
    stage('Checkout') {
            git 'https://github.com/TheGreatMed/angularTest.git'  
    }

    stage('clean project'){
        bat 'cd crud-angular'
        sh 'mvn clean'
    }
    stage('build projet'){ 
        bat 'cd crud-angular'
        sh 'mvn install'
    }
    stage('deploy nexus'){  
        bat 'cd crud-angular' 
        sh 'mvn deploy --settings settings.xml -Dmaven.test.skip=true'
    }   
}
        