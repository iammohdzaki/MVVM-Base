package com.zaki.mvvm_base.extensions

import android.app.Activity
import android.content.Intent

fun Activity.goToActivity(newActivity: Class<*>,doFinish:Boolean){
    val intent = Intent(this,newActivity)
    startActivity(intent)
    if(doFinish) this.finish()
}

fun Activity.goToActivityWithResult(newActivity: Class<*>,doFinish:Boolean,requestCode:Int){
    val intent = Intent(this,newActivity)
    this.startActivityForResult(intent,requestCode)
    if(doFinish) this.finish()
}