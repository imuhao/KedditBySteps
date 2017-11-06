package com.caimuhao.kedditbysteps.fatures.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.caimuhao.kedditbysteps.R
import com.caimuhao.kedditbysteps.commons.adapter.ViewType
import com.caimuhao.kedditbysteps.commons.adapter.ViewTypeDelegateAdapter
import com.caimuhao.kedditbysteps.commons.extensions.inflate

/**
 * @author Smile
 * @time 2017/11/5  16:11
 * @desc ${TODD}
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading)) {

    }
}