package ru.pyroman.mapkit.common.core.network.ktor

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

internal interface HttpEngineFactory {

    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}