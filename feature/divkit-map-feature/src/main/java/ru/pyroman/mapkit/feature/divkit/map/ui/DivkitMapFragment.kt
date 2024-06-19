package ru.pyroman.mapkit.feature.divkit.map.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yandex.mapkit.mapview.MapView
import ru.pyroman.mapkit.feature.divkit.map.databinding.FragmentDivkitMapBinding
import ru.pyroman.mapkit.feature.map.ui.AbstractMapFragment

class DivkitMapFragment : AbstractMapFragment() {

    private val binding: FragmentDivkitMapBinding
        get() = requireNotNull(_binding)
    private var _binding: FragmentDivkitMapBinding? = null

    override val mapView: MapView
        get() = binding.mapview

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDivkitMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}