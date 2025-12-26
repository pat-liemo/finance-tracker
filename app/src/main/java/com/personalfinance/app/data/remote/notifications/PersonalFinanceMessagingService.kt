package com.personalfinance.app.data.remote.notifications

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonalFinanceMessagingService : FirebaseMessagingService() {
    
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        // TODO: Handle FCM messages here
    }
    
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // TODO: Send token to server
    }
}