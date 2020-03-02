package io.github.mohamedisoliman.fancy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.mohamedisoliman.fancy.data.entities.Product
import io.github.mohamedisoliman.fancy.domain.RetrieveProducts
import io.github.mohamedisoliman.fancy.singleArgViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

@ExperimentalCoroutinesApi
class HomeViewModel(private val retrieveProducts: RetrieveProducts) : ViewModel() {


    companion object {
        val FACTORY = singleArgViewModelFactory(::HomeViewModel)
    }

    private val productsList = MutableLiveData<List<Product>>()
    fun productsList(): LiveData<List<Product>> = productsList

    private val progress = MutableLiveData<Boolean>()
    fun progress(): LiveData<Boolean> = progress

    private val error = MutableLiveData<String>()
    fun error(): LiveData<String> = error

    init {
        initViews()
    }

    private fun initViews() {
        viewModelScope.launch {
            retrieveProducts
                .productsFlow()
                .onStart { progress.postValue(true) }
                .onCompletion {
                    progress.postValue(false)
                    it?.let {
                        error.postValue("Something wrong happened!")
                    }
                }
                .catch { Timber.e(it) }
                .collect {
                    if (it.isNotEmpty()) productsList.postValue(it)
                }
        }
    }


}
