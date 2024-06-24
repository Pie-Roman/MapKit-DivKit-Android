package ru.pyroman.mapkit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import ru.pyroman.mapkit.feature.divkit.map.ui.DivkitMapFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<DivkitMapFragment>(
                containerViewId = R.id.fragment_container,
            )
        }
    }
}