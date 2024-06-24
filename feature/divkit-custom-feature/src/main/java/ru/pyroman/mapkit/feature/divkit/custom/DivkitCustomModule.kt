package ru.pyroman.mapkit.feature.divkit.custom

import org.kodein.di.instance
import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.common.core.di.provider

val divkitCustomModule = module("divkitCustomModule") {

    provider<DivCustomViewAdaptersProvider> {
        DivCustomViewAdaptersProviderImpl(
            mapDivCustomViewAdapter = instance(),
        )
    }
}