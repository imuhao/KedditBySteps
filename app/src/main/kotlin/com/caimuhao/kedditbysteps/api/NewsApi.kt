package com.caimuhao.kedditbysteps.api

import retrofit2.Call

/**
 * @author Smile
 * @time 2017/11/9  16:40
 * @desc ${TODD}
 */
interface NewsApi {
    fun getNews(after: String, limit: Int): Call<RedditNewsResponse>
}