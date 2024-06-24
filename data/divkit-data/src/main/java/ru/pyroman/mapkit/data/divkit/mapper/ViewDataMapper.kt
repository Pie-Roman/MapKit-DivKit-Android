package ru.pyroman.mapkit.data.divkit.mapper

import ru.pyroman.mapkit.data.divkit.dto.ViewDataDto
import ru.pyroman.mapkit.domain.divkit.model.ViewData

internal class ViewDataMapper {
    fun map(dto: ViewDataDto): ViewData {
        val rawDivData = requireNotNull(dto.rawDivData)

        return ViewData(
            rawDivData = rawDivData,
        )
    }
}