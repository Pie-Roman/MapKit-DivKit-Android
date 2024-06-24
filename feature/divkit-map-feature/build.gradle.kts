plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.mapkit.feature.divkit.map"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(projects.common.core)

    implementation(projects.feature.mapFeature)
    implementation(projects.feature.divkitFeature)
    implementation(projects.domain.divkitDomain)

    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.lifecycle.runtimeKtx)

    implementation(libs.divkit.div)
    implementation(libs.divkit.core)
    implementation(libs.divkit.json)
}