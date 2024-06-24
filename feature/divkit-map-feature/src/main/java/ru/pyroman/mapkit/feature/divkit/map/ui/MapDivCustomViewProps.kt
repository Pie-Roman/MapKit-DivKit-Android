package ru.pyroman.mapkit.feature.divkit.map.ui

import com.yandex.div2.Div
import org.json.JSONArray
import org.json.JSONObject

class MapDivCustomViewProps(
    val placemarks: List<PlacemarkDivData>,
)

class PlacemarkDivData(
    val id: String,
    val point: Point,
    val div: Div,
)

class Point(
    val latitude: Double,
    val longitude: Double,
)

fun <T> JSONArray.map(transform: (JSONObject) -> T): List<T> {
    val result = ArrayList<T>()
    for (index in 0 until length()) {
        val jsonObject = optJSONObject(index) ?: continue
        result += transform(jsonObject)
    }
    return result
}