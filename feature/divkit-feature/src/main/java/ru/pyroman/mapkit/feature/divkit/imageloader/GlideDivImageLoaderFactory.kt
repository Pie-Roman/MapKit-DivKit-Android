package ru.pyroman.mapkit.feature.divkit.imageloader

import android.content.Context
import com.bumptech.glide.Glide

internal class GlideDivImageLoaderFactory : DivImageLoaderFactory {

    override fun create(context: Context): GlideDivImageLoader {
        return GlideDivImageLoader(
            requestManager = lazy { Glide.with(context) }
        )
    }
}