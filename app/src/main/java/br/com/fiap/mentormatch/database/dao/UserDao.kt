package br.com.fiap.mentormatch.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.mentormatch.model.Users

@Dao
interface UserDao {

    @Insert
    fun save(user: Users): Long

    @Update
    fun update(user: Users): Int

    @Delete
    fun delete(user: Users): Int

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    fun findUserById(id: Int): Users

    @Query("SELECT * FROM tbl_user ORDER BY name ASC")
    fun listUsers(): List<Users>

}