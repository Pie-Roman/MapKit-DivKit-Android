package ru.pyroman.mapkit.feature.divkit.imageloader

import android.content.Context
import com.yandex.div.core.images.DivImageLoader

interface DivImageLoaderFactory {

    fun create(context: Context): DivImageLoader
}