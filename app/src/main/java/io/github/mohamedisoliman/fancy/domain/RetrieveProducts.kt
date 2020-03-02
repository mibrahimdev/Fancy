package io.github.mohamedisoliman.fancy.domain

import io.github.mohamedisoliman.fancy.data.ProductRepositoryContract
import io.github.mohamedisoliman.fancy.data.entities.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import timber.log.Timber

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */
class RetrieveProducts(private val productsRepo: ProductRepositoryContract) {


    @ExperimentalCoroutinesApi
    suspend fun products(): Flow<Product> {
        return productsRepo.fetchProducts().asFlow()
            .flowOn(Dispatchers.IO)
            .filter { it.images != null && it.images.isNotEmpty() }
            .take(50)
            .catch { Timber.e(it) }
    }
}