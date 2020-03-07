package io.github.mohamedisoliman.fancy.ui.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import io.github.mohamedisoliman.fancy.databinding.ProductDetailsFragmentBinding
import io.github.mohamedisoliman.fancy.domain.RetrieveProductDetails
import io.github.mohamedisoliman.fancy.getViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ProductDetailsFragment : Fragment() {

    private lateinit var viewModel: ProductDetailsViewModel
    private lateinit var binding: ProductDetailsFragmentBinding
    private val args: ProductDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =
            getViewModel { ProductDetailsViewModel(args.productDetails, RetrieveProductDetails()) }
        initObservers()
    }

    private fun initObservers() {
        viewModel.getDetailsLiveData().observe(viewLifecycleOwner, Observer {
            showImage(it.image)
            binding.recyclerview.textView3.text = it.description
            binding.recyclerview.textView.text = it.name
            binding.recyclerview.button.text = "%10 discount"
            binding.home.setOnClickListener { findNavController().popBackStack() }
        })

        viewModel.error().observe(viewLifecycleOwner, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
        })
    }

    private fun showImage(image: String?) {
        Picasso.get()
            .load(image)
            .fit()
            .into(
                binding.toolbarImage
            )
    }

}
