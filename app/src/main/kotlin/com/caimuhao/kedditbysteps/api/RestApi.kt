package com.caimuhao.kedditbysteps.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author Smile
 * @time 2017/11/7  10:55
 * @desc ${TODD}
 */

class RestApi {
    private val redditApi: RedditApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        redditApi = retrofit.create(RedditApi::class.java)
    }

    fun getNews(after: String, limit: Int): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }

}