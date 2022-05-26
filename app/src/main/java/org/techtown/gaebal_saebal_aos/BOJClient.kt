package org.techtown.gaebal_saebal_aos

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class BOJClient {
    companion object {
        private const val BASE_URL = "http://203.255.3.246:7072/api/product/"
        fun getApi(): BOJServices = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BOJServices::class.java)
    }
}

data class BOJ(
    @SerializedName("bjNumber") val bjNumber: Int
)

interface BOJServices {
    @GET("/{bjNumber}")
    fun getNum(@Query("bjNumber") bjNumber: Int) : Call<BOJ>
}
