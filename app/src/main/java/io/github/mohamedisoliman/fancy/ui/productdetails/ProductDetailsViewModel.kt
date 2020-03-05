package io.github.mohamedisoliman.fancy.ui.productdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.mohamedisoliman.fancy.domain.RetrieveProductDetails
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val productId: Int,
    private val retrieveProductDetails: RetrieveProductDetails
) : ViewModel() {


    init {
        showProductDetails()
    }

    private fun showProductDetails() {
        viewModelScope.launch {
            retrieveProductDetails.retrieveProductDetails(productId)
                .collect {

                }
        }
    }

}
