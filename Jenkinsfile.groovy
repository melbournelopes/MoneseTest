node {
    stage('FETCH'){
        git url: 'https://github.com/melbournelopes/MoneseTest.git'    
    }
   stage('BUILD'){
       //Building apk
        if (isUnix()) {
            sh './gradlew clean build'
        } else {
            bat 'gradlew.bat clean build'
        }
   }
   stage('TEST'){
       echo 'testing'
   }
   stage('DEPLOY'){
       //Signing apk
       signAndroidApks (
        keyStoreId: "imd",
        keyAlias: "imd_keystore",
        apksToSign: "**/*-unsigned.apk",
        //skipZipalign: true
        )
   }
}
