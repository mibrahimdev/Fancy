package io.github.mohamedisoliman.fancy.ui.productdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.mohamedisoliman.fancy.data.entities.Product
import io.github.mohamedisoliman.fancy.data.entities.ProductDetails
import io.github.mohamedisoliman.fancy.domain.RetrieveProductDetails
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@ExperimentalCoroutinesApi
class ProductDetailsViewModel(
    private val productDetails: ProductDetails,
    private val retrieveProductDetails: RetrieveProductDetails
) : ViewModel() {


    private val detailsLiveData = MutableLiveData<ProductDetails>()
    fun getDetailsLiveData(): LiveData<ProductDetails> = detailsLiveData

    private val error = MutableLiveData<String>()
    fun error(): LiveData<String> = error

    init {
        showProductDetails()
    }

    private fun showProductDetails() {
        viewModelScope.launch {
            if (productDetails.id != null)
                retrieveProductDetails.retrieveProductDetails(productDetails.id)
                    .catch {
                        Timber.e(it)
                        error.postValue(it.message)
                    }
                    .collect {
                        detailsLiveData.postValue(it)
                    }
        }
    }

}
