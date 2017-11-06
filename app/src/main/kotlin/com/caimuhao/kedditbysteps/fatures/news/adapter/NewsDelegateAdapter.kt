package com.caimuhao.kedditbysteps.fatures.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.caimuhao.kedditbysteps.R
import com.caimuhao.kedditbysteps.bean.RedditNewsItem
import com.caimuhao.kedditbysteps.commons.adapter.ViewType
import com.caimuhao.kedditbysteps.commons.adapter.ViewTypeDelegateAdapter
import com.caimuhao.kedditbysteps.commons.extensions.inflate
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * @author Smile
 * @time 2017/11/6  09:18
 * @desc ${TODD}
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {

        private val img_thumbnail = itemView.img_thumbnail
        private val description = itemView.description
        private val author = itemView.author
        private val comments = itemView.comments
        private val time = itemView.time

        fun bind(item: RedditNewsItem) {
            description.text = item.title
            author.text = item.author

        }
    }
}