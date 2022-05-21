package org.techtown.gaebal_saebal_aos

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class GithubClient {
    companion object {
        private const val BASE_URL = "https://api.github.com"
        fun getApi(): GithubService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }
}

data class GithubRepo( // public 한정^^ ㅎㅎ 유저 아이디만 알면 되용갈갈
    @SerializedName("name") val name: String, // repository title
    @SerializedName("html_url") val url: String,
    @SerializedName("issues_url") val issue: String,
    @SerializedName("pulls_url") val pull: String,
    @SerializedName("title") val title: String, // pull or issue title
    @SerializedName("created_at") val created_at: String
)

interface GithubService {
    @GET("users/{owner}/repos")
    fun getRepos(@Path("owner") owner: String) : Single<List<GithubRepo>>
}
