package io.github.mohamedisoliman.fancy.domain

import io.github.mohamedisoliman.fancy.data.ProductRepositoryContract
import io.github.mohamedisoliman.fancy.data.ProductsRepository
import io.github.mohamedisoliman.fancy.data.entities.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

/**
 *
 * Created by Mohamed Ibrahim on 3/3/20.
 */
class RetrieveProductDetails(
    private val productsRepo: ProductRepositoryContract = ProductsRepository()
) {

    suspend fun retrieveProductDetails(id: Int): Flow<Product> {
        return flowOf(productsRepo.fetchProductDetails(id))
    }
}