package ru.pyroman.mapkit.feature.divkit.map.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.yandex.mapkit.mapview.MapView
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.pyroman.mapkit.common.core.di.Inject.instance
import ru.pyroman.mapkit.domain.divkit.usecase.GetViewDataUseCase
import ru.pyroman.mapkit.feature.divkit.map.databinding.FragmentDivkitMapBinding
import ru.pyroman.mapkit.feature.map.ui.AbstractMapFragment

class DivkitMapFragment : AbstractMapFragment() {

    private val binding: FragmentDivkitMapBinding
        get() = requireNotNull(_binding)
    private var _binding: FragmentDivkitMapBinding? = null

    override val mapView: MapView
        get() = binding.mapview

    private val getViewDataUseCase: GetViewDataUseCase = instance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDivkitMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch(
            context = Dispatchers.IO + CoroutineExceptionHandler { coroutineContext, throwable ->

            }
        ) {
            val rawDivData = getViewDataUseCase.execute("map")

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}