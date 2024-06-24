package ru.pyroman.mapkit.feature.divkit.custom

interface DivCustomViewAdaptersProvider {

    fun provide(): List<AbstractDivCustomViewAdapter<*>>
}