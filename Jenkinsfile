node{
    stage('Checkout') {
            git 'https://github.com/TheGreatMed/angularTest.git'  
    }

    stage('clean project'){
        sh 'cd crud-angular'
        sh 'mvn clean'
    }
    stage('build projet'){ 
        sh 'cd crud-angular'
        sh 'mvn install'
    }
    stage('deploy nexus'){  
        sh 'cd crud-angular' 
        sh 'mvn deploy --settings settings.xml -Dmaven.test.skip=true'
    }   
}
      