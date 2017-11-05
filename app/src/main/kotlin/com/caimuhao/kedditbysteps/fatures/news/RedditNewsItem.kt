package com.caimuhao.kedditbysteps.fatures.news

import com.caimuhao.kedditbysteps.commons.adapter.AdapterConstants
import com.caimuhao.kedditbysteps.commons.adapter.ViewType

/**
 * @author Smile
 * @time 2017/11/5  17:34
 * @desc ${TODD}
 */
data class RedditNewsItem(var author: String, var title: String) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}