package io.github.mohamedisoliman.fancy.ui.productdetails

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.mohamedisoliman.fancy.R
import io.github.mohamedisoliman.fancy.domain.RetrieveProductDetails
import io.github.mohamedisoliman.fancy.getViewModel

class ProductDetailsFragment : Fragment() {

    companion object {

        private val KEY_PRODUCT_ID = "PRODUCT_ID"

        fun newInstance(id: Int): ProductDetailsFragment {
            val productDetailsFragment = ProductDetailsFragment()
            productDetailsFragment.arguments = with(Bundle()) {
                putInt(KEY_PRODUCT_ID, id)
                this
            }
            return productDetailsFragment
        }
    }

    private lateinit var viewModel: ProductDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val id = arguments?.getInt(KEY_PRODUCT_ID)
        viewModel = getViewModel { ProductDetailsViewModel(id!!, RetrieveProductDetails()) }
    }

}
