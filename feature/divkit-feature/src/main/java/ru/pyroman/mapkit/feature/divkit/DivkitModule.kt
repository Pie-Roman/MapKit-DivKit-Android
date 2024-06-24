package ru.pyroman.mapkit.feature.divkit

import com.yandex.div.core.DivCustomContainerViewAdapter
import com.yandex.div.core.expression.variables.DivVariableController
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div.json.ParsingErrorLogger
import org.kodein.di.instance
import ru.pyroman.mapkit.common.core.di.module
import ru.pyroman.mapkit.common.core.di.provider
import ru.pyroman.mapkit.common.core.di.singleton
import ru.pyroman.mapkit.common.core.platform.di.contextInstance
import ru.pyroman.mapkit.data.divkit.divkitDataModule
import ru.pyroman.mapkit.domain.divkit.divkitDomainModule
import ru.pyroman.mapkit.feature.divkit.custom.DivCustomContainerViewAdapterImpl
import ru.pyroman.mapkit.feature.divkit.imageloader.DivImageLoaderFactory
import ru.pyroman.mapkit.feature.divkit.imageloader.GlideDivImageLoaderFactory

val divkitModule = module("divkitModule") {
    importAll(
        divkitDomainModule,
        divkitDataModule,
    )

    provider<DivImageLoaderFactory> {
        GlideDivImageLoaderFactory()
    }

    provider<DivCustomContainerViewAdapter> {
        DivCustomContainerViewAdapterImpl(
            context = contextInstance(),
            adaptersProvider = instance(),
        )
    }

    provider {
        DivConfigurationFactory(
            imageLoaderFactory = instance(),
            divCustomContainerViewAdapter = instance(),
            divVariableController = instance(),
        )
    }

    singleton {
        DivContextFactory(
            divConfigurationFactory = instance(),
            context = contextInstance(),
        )
    }

    singleton {
        DivParsingEnvironment(ParsingErrorLogger.LOG)
    }

    provider<DivViewFactory> {
        DivViewFactory(
            contextFactory = instance(),
            environment = instance(),
        )
    }

    singleton {
        DivVariableController()
    }
}