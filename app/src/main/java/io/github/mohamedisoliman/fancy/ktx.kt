package io.github.mohamedisoliman.fancy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */

fun <T : ViewModel, A> singleArgViewModelFactory(constructor: (A) -> T):
            (A) -> ViewModelProvider.NewInstanceFactory {
    return { arg: A ->
        object : ViewModelProvider.NewInstanceFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <V : ViewModel> create(modelClass: Class<V>): V {
                return constructor(arg) as V
            }
        }
    }
}