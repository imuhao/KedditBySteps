package com.caimuhao.kedditbysteps.api

import com.caimuhao.kedditbysteps.bean.RedditNewsItem

/**
 * @author Smile
 * @time 2017/11/7  11:26
 * @desc ${TODD}
 */
data class RedditNews(var after: String, var before: String, var news: List<RedditNewsItem>) {
}