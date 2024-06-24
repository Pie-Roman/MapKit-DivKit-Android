plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.mapkit.feature.divkit"
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

    implementation(projects.domain.divkitDomain)
    implementation(projects.data.divkitData)

    implementation(libs.divkit.div)
    implementation(libs.divkit.core)
    implementation(libs.divkit.json)
    implementation(libs.divkit.logging)

    implementation(libs.glide)

    implementation(libs.androidx.appcompat)
}