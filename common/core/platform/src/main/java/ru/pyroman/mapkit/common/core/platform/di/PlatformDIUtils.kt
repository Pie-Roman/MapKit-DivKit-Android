package ru.pyroman.mapkit.common.core.platform.di

import android.content.Context
import org.kodein.di.DirectDIAware
import org.kodein.di.instance
import ru.pyroman.mapkit.common.core.platform.PlatformConfiguration

fun DirectDIAware.contextInstance(): Context {
    val platformConfiguration = instance<PlatformConfiguration>()
    return platformConfiguration.androidContext
}