package com.caimuhao.kedditbysteps.fatures.news

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caimuhao.kedditbysteps.R
import com.caimuhao.kedditbysteps.bean.RedditNews
import com.caimuhao.kedditbysteps.commons.BaseFragment
import com.caimuhao.kedditbysteps.commons.InfiniteScrollListener
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

    private var redditNews: RedditNews? = null

    private val newsManager by lazy {
        NewsManager()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            news_list.setHasFixedSize(true)
            news_list.layoutManager = LinearLayoutManager(context)
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ requestData() }, news_list.layoutManager as LinearLayoutManager))
            adapter = NewsAdapter()
        }
        requestData()

    }

    private fun requestData() {
        newsManager.getNews(redditNews?.after ?: "", 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ retrievedNews ->
                    redditNews = retrievedNews
                    (news_list.adapter as NewsAdapter).addNews(retrievedNews.news)
                }, { error ->
                    showToast(error.message ?: "")
                })
    }
}