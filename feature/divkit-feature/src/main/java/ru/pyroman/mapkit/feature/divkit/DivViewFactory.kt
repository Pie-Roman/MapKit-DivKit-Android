package ru.pyroman.mapkit.feature.divkit

import android.view.View
import com.yandex.div.DivDataTag
import com.yandex.div.core.view2.Div2View
import com.yandex.div.data.DivParsingEnvironment
import com.yandex.div2.DivData
import org.json.JSONObject

class DivViewFactory internal constructor(
    private val contextFactory: DivContextFactory,
    private val environment: DivParsingEnvironment,
) {

    fun create(
        rawDivData: String,
    ): View {
        val context = contextFactory.create()
        val divData =  parseDivData(rawDivData)

        return Div2View(context).apply {
            setData(divData, DivDataTag(divData.logId))
        }
    }

    private fun parseDivData(divDataRaw: String): DivData {
        val json = JSONObject(divDataRaw)
        val card = json.getJSONObject("card")
        val templates = json.optJSONObject("templates")
        if (templates != null) {
            environment.parseTemplates(templates)
        }
        return DivData(environment, card)
    }
}