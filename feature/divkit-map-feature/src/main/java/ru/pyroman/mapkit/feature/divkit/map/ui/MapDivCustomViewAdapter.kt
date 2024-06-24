package ru.pyroman.mapkit.feature.divkit.map.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.yandex.div.core.DivCustomContainerViewAdapter
import com.yandex.div.core.state.DivStatePath
import com.yandex.div.core.view2.Div2View
import com.yandex.div2.DivCustom
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.ui_view.ViewProvider
import ru.pyroman.mapkit.common.core.di.Inject.instance
import ru.pyroman.mapkit.feature.divkit.custom.AbstractDivCustomViewAdapter
import ru.pyroman.mapkit.feature.divkit.map.databinding.MapContainerViewBinding

class MapDivCustomViewAdapter(
    private val context: Context,
) : AbstractDivCustomViewAdapter<View>() {

    override val customType: String = "map"

    private var _binding: MapContainerViewBinding? = null
    private val binding: MapContainerViewBinding
        get() = requireNotNull(_binding)

    private val mapView: MapView
        get() = binding.mapview

    private val propsMapper: MapDivCustomViewPropsMapper = instance()

    override fun createView(): View {
        return MapContainerViewBinding.inflate(LayoutInflater.from(context)).apply {
            _binding = this
        }.root
    }

    override fun bindView(view: View, divCustom: DivCustom, divView: Div2View) {
        super.bindView(view, divCustom, divView)
        val map = mapView.mapWindow.map
        map.move(POSITION)

        val props = divCustom.customProps?.let { propsMapper.map(it) }
        props?.placemarks.orEmpty().forEach { placemarkDivData ->
            val div = placemarkDivData.div
            val point = Point(
                    placemarkDivData.point.latitude,
                    placemarkDivData.point.longitude,
                )
            val divViewFactory = DivCustomContainerViewAdapter.getDivChildFactory(divView)
            val placemarkView = divViewFactory.createChildView(
                div = div,
                divStatePath = DivStatePath.fromState(divView.id.toLong()),
                divView = divView,
            )
            map.mapObjects.addPlacemark().apply {
                geometry = point
                setView(ViewProvider(placemarkView))
            }
        }
    }

    override fun releaseView(view: View, div: DivCustom) {
        super.releaseView(view, div)
        _binding = null
    }


    companion object {
        private val POINT = Point(55.751280, 37.629720)
        private val POSITION = CameraPosition(POINT, 17.0f, 150.0f, 0.0f)
    }
}