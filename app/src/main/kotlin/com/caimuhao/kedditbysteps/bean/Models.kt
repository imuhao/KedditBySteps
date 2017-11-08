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

data class RedditNews(var after: String, var before: String, var news: List<RedditNewsItem>) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(RedditNewsItem)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(after)
        parcel.writeString(before)
        parcel.writeTypedList(news)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RedditNews> {
        override fun createFromParcel(parcel: Parcel): RedditNews {
            return RedditNews(parcel)
        }

        override fun newArray(size: Int): Array<RedditNews?> {
            return arrayOfNulls(size)
        }
    }

}

data class RedditNewsItem(var author: String, var title: String, var num_comments: Int,
                          var created: Long, var thumbnail: String, var url: String
) : ViewType, Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun getViewType() = AdapterConstants.NEWS
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeInt(num_comments)
        parcel.writeLong(created)
        parcel.writeString(thumbnail)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RedditNewsItem> {
        override fun createFromParcel(parcel: Parcel): RedditNewsItem {
            return RedditNewsItem(parcel)
        }

        override fun newArray(size: Int): Array<RedditNewsItem?> {
            return arrayOfNulls(size)
        }
    }
}
