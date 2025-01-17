package ru.pyroman.mapkit.common.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.pyroman.mapkit.common.core.network.ktor.HttpEngineFactoryAndroid
import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.common.core.di.singleton

val networkModule = module("networkModule") {

    singleton {
        HttpClient(HttpEngineFactoryAndroid().createEngine()) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }

            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }
        }
    }
}