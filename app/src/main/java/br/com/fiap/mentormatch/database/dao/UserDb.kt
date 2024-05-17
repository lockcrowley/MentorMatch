package br.com.fiap.mentormatch.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.fiap.mentormatch.model.Users
import br.com.fiap.mentormatch.utils.Converters

@Database(
    entities = [Users::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class UserDb : RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object {

        private lateinit var instance: UserDb

        fun getDatabase(context: Context): UserDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        UserDb::class.java,
                        "user_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}