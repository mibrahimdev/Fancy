package io.github.mohamedisoliman.fancy.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Mohamed Ibrahim on 3/4/20.
 */

@Parcelize
data class ProductDetails(
    val id: String? = "",
    val name: String? = "",
    val description: String? = "",
    val image: String? = ""
) : Parcelable