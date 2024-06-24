package ru.pyroman.mapkit.feature.divkit.map.ui

import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div2.Div
import org.json.JSONObject

class MapDivCustomViewPropsMapper(
    private val divParsingEnvironment: DivParsingEnvironment,
) {

    fun map(json: JSONObject): MapDivCustomViewProps {
        val placemarks = json.optJSONArray("placemarks")
            ?.map(::mapPlacemark)
            .orEmpty()
            .filterNotNull()

        return MapDivCustomViewProps(
            placemarks = placemarks,
        )
    }

    private fun mapPlacemark(json: JSONObject): PlacemarkDivData? {
        val id = json.optString("id") ?: return null
        val point = json.optJSONObject("point")?.let(::mapPoint) ?: return null
        val div = json.optJSONObject("div")?.let(::mapDiv) ?: return null

        return PlacemarkDivData(
            id = id,
            point = point,
            div =  div,
        )
    }

    private fun mapPoint(json: JSONObject): Point {
        val latitude =  json.optDouble("latitude")
        val longitude = json.optDouble("longitude")

        return Point(
            latitude = latitude,
            longitude = longitude,
        )
    }

    private fun mapDiv(json: JSONObject): Div {
        return Div(divParsingEnvironment, json)
    }
}