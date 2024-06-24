package ru.pyroman.mapkit.feature.divkit.map.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.pyroman.mapkit.common.core.di.Inject.instance
import ru.pyroman.mapkit.domain.divkit.usecase.GetViewDataUseCase
import ru.pyroman.mapkit.feature.divkit.DivViewFactory
import ru.pyroman.mapkit.feature.divkit.map.databinding.DivkitContainerViewBinding
import ru.pyroman.mapkit.feature.map.ui.AbstractMapFragment

class DivkitMapFragment : AbstractMapFragment() {

    private val binding: DivkitContainerViewBinding
        get() = requireNotNull(_binding)
    private var _binding: DivkitContainerViewBinding? = null

    private val divViewFactory: DivViewFactory = instance()
    private val getViewDataUseCase: GetViewDataUseCase = instance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DivkitContainerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch(
            context = Dispatchers.IO + CoroutineExceptionHandler { _, _ ->

            }
        ) {
            val rawDivData = getViewDataUseCase.execute("map").rawDivData
            withContext(Dispatchers.Main) {
                val divView = divViewFactory.create(rawDivData)
                with(binding) {
                    rootView.removeAllViews()
                    rootView.addView(divView)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}