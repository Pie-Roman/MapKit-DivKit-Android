package ru.pyroman.mapkit.data.divkit.repository

import ru.pyroman.mapkit.data.divkit.datasource.network.DivkitNetworkDataSource
import ru.pyroman.mapkit.data.divkit.mapper.ViewDataMapper
import ru.pyroman.mapkit.domain.divkit.model.ViewData
import ru.pyroman.mapkit.domain.divkit.repository.DivkitRepository

internal class DivkitRepositoryImpl(
    private val mapper: ViewDataMapper,
    private val networkDataSource: DivkitNetworkDataSource,
) : DivkitRepository {
    override suspend fun getViewData(path: String): ViewData {
        val dto = networkDataSource.getViewData(path)

        return mapper.map(dto)
    }
}