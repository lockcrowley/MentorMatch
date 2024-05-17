package br.com.fiap.mentormatch.database.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import br.com.fiap.mentormatch.database.repository.NotificationEntity

@Database(entities = [NotificationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notificationDao(): NotificationDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "example_database"
                ).build()
                this.instance = instance
                instance
            }
        }
    }
}
