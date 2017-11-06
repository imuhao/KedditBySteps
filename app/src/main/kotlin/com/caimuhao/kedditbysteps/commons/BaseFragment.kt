package com.caimuhao.kedditbysteps.commons

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * @author Smile
 * @time 2017/11/6  17:10
 * @desc ${TODD}
 */
open class BaseFragment : Fragment() {

    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }

}