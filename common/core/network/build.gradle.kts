plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.mapkit.common.core.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    api(libs.ktor.core)
    api(libs.kotlinx.serialization)

    implementation(libs.ktor.contentNegotiation)
    implementation(libs.ktor.json)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.serializationKotlinX)
    implementation(libs.ktor.android)

    implementation(libs.kodein)

    implementation(projects.common.core.di)
}