import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

val mapkitApiKey: String = gradleLocalProperties(rootDir, providers).getProperty("MAPKIT_API_KEY")

android {
    namespace = "ru.pyroman.mapkit"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "ru.pyroman.mapkit"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "MAPKIT_API_KEY", mapkitApiKey)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.fragmentKtx)

    implementation(libs.yandex.mapkit)

    implementation(projects.common.umbrella)
}