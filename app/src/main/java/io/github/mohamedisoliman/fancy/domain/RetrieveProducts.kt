package io.github.mohamedisoliman.fancy.domain

import io.github.mohamedisoliman.fancy.data.ProductRepositoryContract
import io.github.mohamedisoliman.fancy.data.ProductsRepository
import io.github.mohamedisoliman.fancy.data.entities.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import timber.log.Timber

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */
class RetrieveProducts(private val productsRepo: ProductRepositoryContract = ProductsRepository()) {


    @ExperimentalCoroutinesApi
    suspend fun productsFlow(): Flow<List<Product>> {
        return productsRepo.fetchProducts().asFlow()
            .filter { it.images != null && it.images.isNotEmpty() }
            .take(50)
            //can't move catch to down stream.
            .catch {
                Timber.e(it)
            }
            .scan(emptyList()) { acc, product -> acc + product }
    }
}