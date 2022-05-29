package org.techtown.gaebal_saebal_aos

import com.google.gson.annotations.SerializedName
//import io.reactivex.Single
//import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.*
import retrofit2.http.*

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

data class bjNumber(
    @SerializedName("bjNumber") val bjNumber: Int
)

data class title (
    @SerializedName("Title") val Title: String
)

interface BOJServices {
    @GET("{bjNumber")
    fun getBOJNumber (
        @Path("bjNumber") bjNumber: Int?
    )
}


