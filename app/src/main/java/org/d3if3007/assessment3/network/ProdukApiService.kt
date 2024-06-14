package org.d3if3007.assessment3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if3007.assessment3.model.OpStatus
import org.d3if3007.assessment3.model.Produk
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

private const val BASE_URL = "https://4602myproductapi.000webhostapp.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ProdukApiService {
    @GET("/6706223000/product")
    suspend fun getProduk(
        @Header("Authorization") userId: String
    ): List<Produk>

    @Multipart
    @POST("/6706223000/product")
    suspend fun postProduk(
        @Header("Authorization") userId: String,
        @Part("brand") nama: RequestBody,
        @Part("category") kategori: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @GET("/6706223000/product/delete/{id}")
    suspend fun deleteProduk(
        @Header("Authorization") userId: String,
        @Path("id") id: String
    ): OpStatus
}

object ProdukApi{
    val service: ProdukApiService by lazy {
        retrofit.create(ProdukApiService::class.java)
    }

    fun getProdukUrl(imageId: String): String {
        return "${BASE_URL}/images/${imageId}"
    }
}

enum class ApiStatus {LOADING, SUCCESS, FAILED}