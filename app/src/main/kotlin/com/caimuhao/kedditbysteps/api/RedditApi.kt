package com.caimuhao.kedditbysteps.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Smile
 * @time 2017/11/7  10:45
 * @desc ${TODD}
 */

interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String, @Query("limit") limit: Int)
            : Call<RedditNewsResponse>
}