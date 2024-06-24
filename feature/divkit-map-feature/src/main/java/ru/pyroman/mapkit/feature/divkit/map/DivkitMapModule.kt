package ru.pyroman.mapkit.feature.divkit.map

import org.kodein.di.instance
import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.common.core.di.provider
import ru.pyroman.mapkit.common.core.platform.di.contextInstance
import ru.pyroman.mapkit.feature.divkit.map.ui.MapDivCustomViewAdapter
import ru.pyroman.mapkit.feature.divkit.map.ui.MapDivCustomViewPropsMapper

val divkitMapModule = module("divkitMapModule") {

    provider {
        MapDivCustomViewAdapter(
            context = contextInstance(),
        )
    }

    provider {
        MapDivCustomViewPropsMapper(
            divParsingEnvironment = instance(),
        )
    }
}