package com.caimuhao.kedditbysteps

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caimuhao.kedditbysteps.commons.inflate

/**
 * @author Smile
 * @time 2017/11/4  13:26
 * @desc ${TODD}
 */
class NewsFragment : Fragment() {

    private var newsList: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = container?.inflate(R.layout.fragment_news)
        newsList = view?.findViewById(R.id.news_list)
        newsList?.setHasFixedSize(true)
        newsList?.layoutManager = LinearLayoutManager(context)

        return view
    }

}