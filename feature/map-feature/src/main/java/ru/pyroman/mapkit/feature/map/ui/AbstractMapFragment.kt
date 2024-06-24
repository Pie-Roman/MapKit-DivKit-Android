package ru.pyroman.mapkit.feature.map.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.yandex.mapkit.MapKitFactory

abstract class AbstractMapFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(context)
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
    }

    override fun onStop() {
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}