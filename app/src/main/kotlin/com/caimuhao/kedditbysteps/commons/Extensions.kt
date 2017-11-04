package com.caimuhao.kedditbysteps.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Smile
 * @time 2017/11/4  13:49
 * @desc ${TODD}
 */

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
