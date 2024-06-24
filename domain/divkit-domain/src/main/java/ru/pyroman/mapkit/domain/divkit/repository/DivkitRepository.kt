package ru.pyroman.mapkit.domain.divkit.repository

import ru.pyroman.mapkit.domain.divkit.model.ViewData

interface DivkitRepository {

    suspend fun getViewData(path: String): ViewData
}