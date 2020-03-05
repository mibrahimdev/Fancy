package io.github.mohamedisoliman.fancy.data

import io.github.mohamedisoliman.fancy.data.entities.Product
import io.github.mohamedisoliman.fancy.data.remote.DataKickRemote
import io.github.mohamedisoliman.fancy.data.remote.Remote

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */
class ProductsRepository(private val remote: DataKickRemote = Remote.dataKickRemote) :
    ProductRepositoryContract {

    override suspend fun fetchProducts(): List<Product> = remote.fetchProducts()

    override suspend fun fetchProductDetails(id: Int): Product = remote.fetchProductDetails(id)

}

interface ProductRepositoryContract {
    suspend fun fetchProducts(): List<Product>
    suspend fun fetchProductDetails(id: Int): Product
}