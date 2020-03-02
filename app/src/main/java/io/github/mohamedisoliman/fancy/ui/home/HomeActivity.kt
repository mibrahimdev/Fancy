package io.github.mohamedisoliman.fancy.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.mohamedisoliman.fancy.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }
}
