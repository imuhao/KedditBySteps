package com.caimuhao.kedditbysteps.bean

import android.os.Parcel
import android.os.Parcelable
import com.caimuhao.kedditbysteps.commons.adapter.AdapterConstants
import com.caimuhao.kedditbysteps.commons.adapter.ViewType

/**
 * @author Smile
 * @time 2017/11/8  10:15
 * @desc ${TODD}
 */

data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.createTypedArrayList(RedditNewsItem.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(after)
        writeString(before)
        writeTypedList(news)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RedditNews> = object : Parcelable.Creator<RedditNews> {
            override fun createFromParcel(source: Parcel): RedditNews = RedditNews(source)
            override fun newArray(size: Int): Array<RedditNews?> = arrayOfNulls(size)
        }
    }
}

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String?
) : ViewType, Parcelable {
    override fun getViewType() = AdapterConstants.NEWS

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readLong(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(author)
        writeString(title)
        writeInt(numComments)
        writeLong(created)
        writeString(thumbnail)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RedditNewsItem> = object : Parcelable.Creator<RedditNewsItem> {
            override fun createFromParcel(source: Parcel): RedditNewsItem = RedditNewsItem(source)
            override fun newArray(size: Int): Array<RedditNewsItem?> = arrayOfNulls(size)
        }
    }
}
