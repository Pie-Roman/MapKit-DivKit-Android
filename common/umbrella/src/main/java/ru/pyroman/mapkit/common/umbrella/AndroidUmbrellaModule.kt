package ru.pyroman.mapkit.common.umbrella

import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.feature.divkit.custom.divkitCustomModule
import ru.pyroman.mapkit.feature.divkit.divkitModule
import ru.pyroman.mapkit.feature.divkit.map.divkitMapModule

val androidUmbrellaModule = module("androidUmbrellaModule") {
    importAll(
        divkitCustomModule,
        divkitModule,
        divkitMapModule,
    )
}