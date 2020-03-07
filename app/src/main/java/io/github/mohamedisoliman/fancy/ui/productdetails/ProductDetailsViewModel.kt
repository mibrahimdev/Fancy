package io.github.mohamedisoliman.fancy.ui.productdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.mohamedisoliman.fancy.data.entities.ProductDetails
import io.github.mohamedisoliman.fancy.domain.RetrieveProductDetails
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val productDetails: ProductDetails,
    private val retrieveProductDetails: RetrieveProductDetails
) : ViewModel() {


    init {
        showProductDetails()
    }

    private fun showProductDetails() {
        viewModelScope.launch {
            if (productDetails.id != null)
                retrieveProductDetails.retrieveProductDetails(productDetails.id)
                    .collect {

                    }
        }
    }

}
