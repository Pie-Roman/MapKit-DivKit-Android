package ru.pyroman.mapkit.data.divkit

import org.kodein.di.instance
import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.common.core.di.provider
import ru.pyroman.mapkit.common.core.di.singleton
import ru.pyroman.mapkit.data.divkit.datasource.network.DivkitNetworkDataSource
import ru.pyroman.mapkit.data.divkit.datasource.network.httpclient.DivkitHttpClient
import ru.pyroman.mapkit.data.divkit.datasource.network.httpclient.DivkitHttpClientConfigProvider
import ru.pyroman.mapkit.data.divkit.mapper.ViewDataMapper
import ru.pyroman.mapkit.data.divkit.repository.DivkitRepositoryImpl
import ru.pyroman.mapkit.domain.divkit.repository.DivkitRepository

val divkitDataModule = module("divkitDataModule") {

    singleton {
        DivkitHttpClientConfigProvider().provide()
    }

    singleton {
        DivkitHttpClient(
            httpClient = instance(),
            config = instance(),
        )
    }

    provider<DivkitNetworkDataSource> {
        DivkitNetworkDataSource(
            divkitHttpClient = instance(),
        )
    }

    provider<ViewDataMapper> {
        ViewDataMapper()
    }

    provider<DivkitRepository> {
        DivkitRepositoryImpl(
            mapper = instance(),
            networkDataSource = instance(),
        )
    }
}