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
        private const val BASE_URL = "https://api.github.com/"
        fun getApi(): GithubService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubService::class.java)
    }
}

data class Owner(
    @SerializedName("login") val login: String, // 레포주인 이름
)

data class GithubRepo(
    @SerializedName("name") val name: String, // repository title
    @SerializedName("full_name") val full_name: String,
    @SerializedName("owner") val issue: Owner,
    @SerializedName("login") val pull: String,
)

data class GitHubIssue(
    @SerializedName("number") val number: Int,
    @SerializedName("title") val title: String,
    @SerializedName("created_at") val create_at: String,
)

data class GitHubPR(
    @SerializedName("number") val name: Int,
    @SerializedName("title") val url: String,
    @SerializedName("created_at") val issue: String,
)

//여기부턴 다 커밋 구조체
data class AutAuthor(
    @SerializedName("date") val date: String,
)

data class Commit(
    @SerializedName("author") val author: AutAuthor,
    @SerializedName("message") val message: String,
)

data class GitHubCommit(
    @SerializedName("commit") val commit: Commit,
    @SerializedName("sha") val sha: String,
)

public interface GithubService {
    @GET("user/repos")
    fun getRepos(
        @Header("Authorization") auth:String?
    ) : Single<List<GithubRepo>>

    @GET("repos/{user}/{repo}/issues?state=all&page=1&per_page=15")
    fun getIssues(
        @Header("Authorization") auth:String?,
        @Path("user") user: String?,
        @Path("repo") repo: String?
    ) : Single<List<GitHubIssue>>

    @GET("repos/{user}/{repo}/pulls?state=all&page=1&per_page=10")
    fun getPRs(
        @Header("Authorization") auth:String?,
        @Path("user") user: String?,
        @Path("repo") repo: String?
    ) : Single<List<GitHubPR>>

    @GET("repos/{user}/{repo}/commits?page=1&per_page=10")
    fun getCommits(
        @Header("Authorization") auth:String?,
        @Path("user") user: String?,
        @Path("repo") repo: String?
    ) : Single<List<GitHubCommit>>
}


