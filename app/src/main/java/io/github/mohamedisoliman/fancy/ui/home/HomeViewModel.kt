package io.github.mohamedisoliman.fancy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.mohamedisoliman.fancy.data.entities.Product
import io.github.mohamedisoliman.fancy.domain.RetrieveProducts
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class HomeViewModel(private val retrieveProducts: RetrieveProducts) : ViewModel() {

    private val productsList = MutableLiveData<List<Product>>()
    fun productsList(): LiveData<List<Product>> = productsList

    private val progress = MutableLiveData<Boolean>()
    fun progress(): LiveData<Boolean> = progress

    private val error = MutableLiveData<String>()
    fun error(): LiveData<String> = error

    init {

    }

    @ExperimentalCoroutinesApi
    fun initViews() {
        viewModelScope.launch {
            progress.postValue(true)
            val list = retrieveProducts.productsFlow().toList()
            productsList.postValue(list)
            progress.postValue(false)
        }
    }


}
