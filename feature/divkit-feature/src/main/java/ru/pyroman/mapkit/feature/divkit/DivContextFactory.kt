package ru.pyroman.mapkit.feature.divkit

import android.content.Context
import android.view.ContextThemeWrapper
import com.yandex.div.core.Div2Context

internal class DivContextFactory(
    private val divConfigurationFactory: DivConfigurationFactory,
    private val context: Context,
) {

    fun create(): Div2Context {
        val configuration = divConfigurationFactory.create(context)
        val themeResId = R.style.BaseAppTheme

        return Div2Context(
            baseContext = ContextThemeWrapper(context, themeResId),
            configuration = configuration,
        )
    }
}