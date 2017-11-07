package com.caimuhao.kedditbysteps.fatures.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.caimuhao.kedditbysteps.bean.RedditNewsItem
import com.caimuhao.kedditbysteps.commons.adapter.AdapterConstants
import com.caimuhao.kedditbysteps.commons.adapter.ViewType
import com.caimuhao.kedditbysteps.commons.adapter.ViewTypeDelegateAdapter

/**
 * @author Smile
 * @time 2017/11/5  16:02
 * @desc ${TODD}
 */
class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.NEWS, NewsDelegateAdapter())
        items = ArrayList()
    }

    fun addNews(news: List<RedditNewsItem>) {
        items.addAll(news)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items.get(position).getViewType()

    fun getNews(): List<RedditNewsItem> {
        return items.filter {
            it.getViewType() == AdapterConstants.NEWS
        }.map {
            it as RedditNewsItem
        }
    }
}