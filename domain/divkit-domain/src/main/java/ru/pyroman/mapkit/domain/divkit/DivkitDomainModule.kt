package ru.pyroman.mapkit.domain.divkit

import org.kodein.di.instance
import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.common.core.di.provider
import ru.pyroman.mapkit.domain.divkit.usecase.GetViewDataUseCase

val divkitDomainModule = module("divkitDomainModule") {

    provider {
        GetViewDataUseCase(
            divkitRepository = instance(),
        )
    }
}