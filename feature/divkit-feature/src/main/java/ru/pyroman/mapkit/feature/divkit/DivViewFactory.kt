package ru.pyroman.mapkit.feature.divkit

import android.view.View
import com.yandex.div.DivDataTag
import com.yandex.div.core.view2.Div2View
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div2.DivData
import org.json.JSONObject

internal class DivViewFactory(
    private val contextFactory: DivContextFactory,
    private val environment: DivParsingEnvironment,
) {

    fun create(
        rawDivData: String,
    ): List<View> {
        val context = contextFactory.create()

        return parseDivData(rawDivData).map { divData ->
            Div2View(context).apply {
                setData(divData, DivDataTag(divData.logId))
            }
        }
    }

    private fun parseDivData(divDataRaw: String): List<DivData> {
        val json = JSONObject(divDataRaw)
        val cards = json.getJSONArray("cards")
        val templates = json.optJSONObject("templates")
        if (templates != null) {
            environment.parseTemplates(templates)
        }
        return (0 until cards.length()).map { index ->
            val card = cards.getJSONObject(index)
            DivData(environment, card)
        }
    }
}