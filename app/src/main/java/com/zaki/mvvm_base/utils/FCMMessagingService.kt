package com.zaki.mvvm_base.utils

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.e("TAG", "From: ${remoteMessage?.from}")

        // Check if message contains a notification payload.
        remoteMessage.data.let {
            Log.e("TAG", "Message Notification title: ${it["title"]}")
            Log.e("TAG", "Message Notification body: ${it["body"]}")
            sendNotification(it["title"]!!, it["body"]!!)
        }
    }

    override fun onNewToken(token: String) {
        Log.e("TAG", "Refreshed token: $token")
    }

    private fun sendNotification(messageTitle: String, messageBody: String) {
        val notificationManager = ContextCompat.getSystemService(applicationContext, NotificationManager::class.java) as NotificationManager
        notificationManager.sendNotification(messageTitle, messageBody, applicationContext)
    }
}