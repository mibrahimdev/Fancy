package io.github.mohamedisoliman.fancy.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import io.github.mohamedisoliman.fancy.R
import io.github.mohamedisoliman.fancy.databinding.HomeFragmentBinding
import io.github.mohamedisoliman.fancy.domain.RetrieveProducts
import timber.log.Timber

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModelProvider = ViewModelProvider(this, HomeViewModel.FACTORY(RetrieveProducts()))
        viewModel = viewModelProvider[HomeViewModel::class.java]
        initObservers()
    }

    private fun initObservers() {
        viewModel.error().observe(viewLifecycleOwner, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
        })

        viewModel.progress().observe(viewLifecycleOwner, Observer {
            if (it) binding.progressBar.show() else binding.progressBar.hide()
        })

        viewModel.productsList().observe(viewLifecycleOwner, Observer {
            Timber.d("Data $it")
        })
    }

}
