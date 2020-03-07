package io.github.mohamedisoliman.fancy.domain

import io.github.mohamedisoliman.fancy.data.ProductRepositoryContract
import io.github.mohamedisoliman.fancy.data.ProductsRepository
import io.github.mohamedisoliman.fancy.data.entities.Product
import io.github.mohamedisoliman.fancy.data.entities.ProductDetails
import io.github.mohamedisoliman.fancy.data.entities.toProductDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import timber.log.Timber

/**
 *
 * Created by Mohamed Ibrahim on 3/3/20.
 */
class RetrieveProductDetails(
    private val productsRepo: ProductRepositoryContract = ProductsRepository()
) {

    suspend fun retrieveProductDetails(id: String): Flow<ProductDetails> {
        return flowOf(productsRepo.fetchProductDetails(id)).map { it.toProductDetails() }
    }
}