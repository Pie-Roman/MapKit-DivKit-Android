package ru.pyroman.mapkit

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import ru.pyroman.mapkit.common.core.platform.PlatformConfiguration
import ru.pyroman.mapkit.common.umbrella.PlatformSDK
import ru.pyroman.mapkit.common.umbrella.androidUmbrellaModule

class MapKitDivKitApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initMapKit()
        initPlatform()
    }

    private fun initMapKit() {
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
    }

    private fun initPlatform() {
        PlatformSDK.initPlatform(
            configuration = PlatformConfiguration(applicationContext),
            platformModule = androidUmbrellaModule,
        )
    }
}