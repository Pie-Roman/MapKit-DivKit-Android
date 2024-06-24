plugins {
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "ru.pyroman.mapkit.common.umbrella"
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
    api(projects.common.core)
    api(projects.common.core.platform)
    api(projects.common.core.network)

    api(projects.feature.divkitFeature)
    api(projects.feature.divkitCustomFeature)
    api(projects.feature.divkitMapFeature)
    api(projects.feature.mapFeature)
}