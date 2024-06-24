package ru.pyroman.mapkit.feature.divkit.custom

import ru.pyroman.mapkit.feature.divkit.map.ui.MapDivCustomViewAdapter

internal class DivCustomViewAdaptersProviderImpl(
    private val mapDivCustomViewAdapter: MapDivCustomViewAdapter,
) : DivCustomViewAdaptersProvider {

    override fun provide(): List<AbstractDivCustomViewAdapter<*>> = listOf(
        mapDivCustomViewAdapter,
    )
}