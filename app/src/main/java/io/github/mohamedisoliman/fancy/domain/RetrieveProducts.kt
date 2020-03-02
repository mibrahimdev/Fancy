package io.github.mohamedisoliman.fancy.domain

import io.github.mohamedisoliman.fancy.data.ProductRepositoryContract
import io.github.mohamedisoliman.fancy.data.ProductsRepository
import io.github.mohamedisoliman.fancy.data.entities.Product
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.scan

/**
 *
 * Created by Mohamed Ibrahim on 3/2/20.
 */
class RetrieveProducts(private val productsRepo: ProductRepositoryContract = ProductsRepository()) {


    @ExperimentalCoroutinesApi
    suspend fun productsFlow(): Flow<List<Product>> {
        return productsRepo.fetchProducts().asFlow()
            .filter { it.name?.length ?: 0 > 10 }//data transformation and business logic
            .scan(emptyList()) { acc: List<Product>, product -> acc + product }

    }
}