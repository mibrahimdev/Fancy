package io.github.mohamedisoliman.fancy.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.github.mohamedisoliman.fancy.R
import io.github.mohamedisoliman.fancy.data.entities.Product
import io.github.mohamedisoliman.fancy.databinding.ItemProductBinding

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */

class ProductsAdapter(
    private val onItemClicked: (Product) -> Unit
) :
    RecyclerView.Adapter<ProductViewHolder>() {

    private val products = mutableListOf<Product>()

    fun setData(products: List<Product>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        return ProductViewHolder(
            onItemClicked,
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

}

class ProductViewHolder(
    private val onItemClicked: (Product) -> Unit,
    private val binding: ItemProductBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product) {
        binding.root.setOnClickListener { onItemClicked(item) }
        binding.productName.text = item.name
        Picasso.get()
            .load(item.randomImage())
            .into(binding.productImage)

    }

}