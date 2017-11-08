package com.caimuhao.kedditbysteps.bean

import com.caimuhao.kedditbysteps.commons.adapter.AdapterConstants
import com.caimuhao.kedditbysteps.commons.adapter.ViewType

/**
 * @author Smile
 * @time 2017/11/8  10:15
 * @desc ${TODD}
 */

data class RedditNews(var after: String, var before: String, var news: List<RedditNewsItem>) {

}

data class RedditNewsItem(var author: String, var title: String, var num_comments: Int,
                          var created: Long, var thumbnail: String, var url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}
