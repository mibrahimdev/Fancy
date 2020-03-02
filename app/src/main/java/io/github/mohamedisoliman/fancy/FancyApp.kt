package io.github.mohamedisoliman.fancy

import android.app.Application
import timber.log.Timber

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */
class FancyApp : Application() {


    override fun onCreate() {
        super.onCreate()
        
        Timber.plant(Timber.DebugTree())
    }
}