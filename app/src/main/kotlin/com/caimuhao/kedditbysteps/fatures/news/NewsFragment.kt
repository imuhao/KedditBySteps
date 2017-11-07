package com.caimuhao.kedditbysteps.fatures.news

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caimuhao.kedditbysteps.R
import com.caimuhao.kedditbysteps.commons.BaseFragment
import com.caimuhao.kedditbysteps.commons.extensions.inflate
import com.caimuhao.kedditbysteps.commons.extensions.showToast
import com.caimuhao.kedditbysteps.fatures.news.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @author Smile
 * @time 2017/11/4  13:26
 * @desc ${TODD}
 */
class NewsFragment : BaseFragment() {

    private val newsManager by lazy {
        NewsManager()
    }

    private val newsList by lazy {
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        news_list
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var adapter = NewsAdapter()
        newsList.adapter = adapter

        refreshData()
    }

    fun refreshData() {
        newsManager.getNews("", 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ retrievedNews ->
                    var redditNews = retrievedNews
                    (newsList.adapter as NewsAdapter).addNews(redditNews.news)
                }, { error ->
                    showToast(error.message ?: "")
                })
    }
}