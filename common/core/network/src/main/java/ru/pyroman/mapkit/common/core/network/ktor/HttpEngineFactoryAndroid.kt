package ru.pyroman.mapkit.common.core.network.ktor

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android

internal class HttpEngineFactoryAndroid {

    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = Android
}