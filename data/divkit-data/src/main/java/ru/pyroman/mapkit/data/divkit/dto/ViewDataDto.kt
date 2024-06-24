package ru.pyroman.mapkit.data.divkit.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class ViewDataDto(
    @SerialName("divan") val rawDivData: String?,
)