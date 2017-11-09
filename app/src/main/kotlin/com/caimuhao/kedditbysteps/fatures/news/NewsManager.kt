package com.caimuhao.kedditbysteps.fatures.news

import com.caimuhao.kedditbysteps.api.NewsApi
import com.caimuhao.kedditbysteps.api.RestApi
import com.caimuhao.kedditbysteps.bean.RedditNews
import com.caimuhao.kedditbysteps.bean.RedditNewsItem
import rx.Observable

/**
 * @author Smile
 * @time 2017/11/6  14:45
 * @desc ${TODD}
 */
class NewsManager(private val api: NewsApi = RestApi()) {

    fun getNews(after: String, limit: Int = 10): Observable<RedditNews> {
        return Observable.create { subscriber ->
            val execute = api.getNews(after, limit).execute()
            var response = execute.body().data
            if (execute.isSuccessful) {
                var items = response.children.map {
                    var item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                var news = RedditNews(response.after ?: "", response.before ?: "", items)
                subscriber.onNext(news)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(execute.message()))
            }
        }
    }
}