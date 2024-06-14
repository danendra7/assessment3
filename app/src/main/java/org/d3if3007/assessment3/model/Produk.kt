package org.d3if3007.assessment3.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Produk(

    @Json(name = "brand") val nama: String?,
    @Json(name = "category") val kategori: String?,
    @Json(name = "image") val imageId: String,
    @Json(name = "id") val id:String,
//    val mine: Int
)
@JsonClass(generateAdapter = true)
data class ListProduk(val products:List<Produk>)
