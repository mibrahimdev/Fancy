package io.github.mohamedisoliman.fancy.ui.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import io.github.mohamedisoliman.fancy.R
import io.github.mohamedisoliman.fancy.domain.RetrieveProductDetails
import io.github.mohamedisoliman.fancy.getViewModel

class ProductDetailsFragment : Fragment() {

    private lateinit var viewModel: ProductDetailsViewModel
    val args: ProductDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            getViewModel { ProductDetailsViewModel(args.productDetails, RetrieveProductDetails()) }
    }

}
