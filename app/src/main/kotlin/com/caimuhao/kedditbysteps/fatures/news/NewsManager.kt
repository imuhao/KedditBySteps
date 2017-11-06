package com.caimuhao.kedditbysteps.fatures.news

import com.caimuhao.kedditbysteps.bean.RedditNewsItem
import rx.Observable

/**
 * @author Smile
 * @time 2017/11/6  14:45
 * @desc ${TODD}
 */
class NewsManager {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create { subscriber ->
            var news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(RedditNewsItem("smile" + i, "title" + i))
            }
            subscriber.onNext(news)
            subscriber.onCompleted()
        }
    }
}