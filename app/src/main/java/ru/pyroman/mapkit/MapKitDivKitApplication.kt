package ru.pyroman.mapkit

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class MapKitDivKitApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initMapKit()
    }

    private fun initMapKit() {
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
    }
}