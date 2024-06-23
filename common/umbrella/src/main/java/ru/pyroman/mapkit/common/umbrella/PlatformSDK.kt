package ru.pyroman.mapkit.common.umbrella

import org.kodein.di.DI
import org.kodein.di.direct
import ru.pyroman.mapkit.common.core.di.Inject
import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.common.core.di.singleton
import ru.pyroman.mapkit.common.core.network.networkModule
import ru.pyroman.mapkit.common.core.platform.PlatformConfiguration

object PlatformSDK {

    fun initPlatform(
        configuration: PlatformConfiguration,
        platformModule: DI.Module,
    ) {
        val platformConfigurationModule = module("platformConfiguration") {
            singleton { configuration }
        }

        Inject.createDependencies(
            DI {
                importAll(
                    platformConfigurationModule,
                    platformModule,
                    networkModule,
                )
            }.direct
        )
    }
}