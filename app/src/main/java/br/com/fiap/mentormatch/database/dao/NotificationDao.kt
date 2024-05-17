package br.com.fiap.mentormatch.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.mentormatch.database.repository.NotificationEntity

@Dao
interface NotificationDao {
    @Insert
    suspend fun insert(notification: NotificationEntity)

    @Query("SELECT * FROM notifications")
    suspend fun getAllNotifications(): List<NotificationEntity>}