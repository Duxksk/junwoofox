
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.junwoofox.browser"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.junwoofox.browser"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation("androidx.webkit:webkit:1.8.0")
}
