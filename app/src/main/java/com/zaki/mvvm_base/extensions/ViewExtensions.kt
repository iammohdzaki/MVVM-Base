package com.zaki.mvvm_base.extensions

import android.view.View

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}

fun View.setEnabledWithAlpha(isEnabled: Boolean, alpha: Float = 0.4f) {
    this.isEnabled = isEnabled
    this.alpha = alpha
}