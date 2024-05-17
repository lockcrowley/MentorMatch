package br.com.fiap.mentormatch.model

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.util.Log
import br.com.fiap.mentormatch.database.dao.AppDatabase
import br.com.fiap.mentormatch.database.repository.NotificationEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PushNotifications : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
            saveNotificationData(remoteMessage.data)
        }

        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
        }
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
    }

    private fun saveNotificationData(data: Map<String, String>) {
        val id = data["id"]?.toIntOrNull() ?: 0
        val message = data["message"] ?: ""

        val notificationEntity = NotificationEntity(id = id, message = message)

        val db = AppDatabase.getDatabase(applicationContext)
        val notificationDao = db.notificationDao()

        CoroutineScope(Dispatchers.IO).launch {
            notificationDao.insert(notificationEntity)
        }
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }
}

