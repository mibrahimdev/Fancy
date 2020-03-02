package io.github.mohamedisoliman.fancy.data.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Product(
    @Json(name = "alcohol_by_volume")
    val alcoholByVolume: Double? = 0.0,
    @Json(name = "author")
    val author: String? = "",
    @Json(name = "brand_name")
    val brandName: String? = "",
    @Json(name = "calories")
    val calories: Int? = 0,
    @Json(name = "carbohydrate")
    val carbohydrate: Int? = 0,
    @Json(name = "cholesterol")
    val cholesterol: Int? = 0,
    @Json(name = "fat")
    val fat: Double? = 0.0,
    @Json(name = "fat_calories")
    val fatCalories: Int? = 0,
    @Json(name = "fiber")
    val fiber: Int? = 0,
    @Json(name = "gtin14")
    val gtin14: String? = "",
    @Json(name = "images")
    val images: List<Image?>? = listOf(),
    @Json(name = "ingredients")
    val ingredients: String? = "",
    @Json(name = "monounsaturated_fat")
    val monounsaturatedFat: Double? = 0.0,
    @Json(name = "name")
    val name: String? = "",
    @Json(name = "pages")
    val pages: Int? = 0,
    @Json(name = "polyunsaturated_fat")
    val polyunsaturatedFat: Double? = 0.0,
    @Json(name = "potassium")
    val potassium: Int? = 0,
    @Json(name = "protein")
    val protein: Int? = 0,
    @Json(name = "publisher")
    val publisher: String? = "",
    @Json(name = "saturated_fat")
    val saturatedFat: Double? = 0.0,
    @Json(name = "serving_size")
    val servingSize: String? = "",
    @Json(name = "servings_per_container")
    val servingsPerContainer: String? = "",
    @Json(name = "size")
    val size: String? = "",
    @Json(name = "sodium")
    val sodium: Int? = 0,
    @Json(name = "sugars")
    val sugars: Int? = 0,
    @Json(name = "trans_fat")
    val transFat: Double? = 0.0
) {

    fun randomImage(): String {
        val keyword = listOf("water", "landscape", "sky")
        return "https://source.unsplash.com/featured/?${keyword.random()},${keyword.random()}"
    }
}