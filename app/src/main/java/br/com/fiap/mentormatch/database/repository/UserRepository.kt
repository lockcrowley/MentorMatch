package br.com.fiap.mentormatch.database.repository

import android.content.Context
import br.com.fiap.mentormatch.database.dao.UserDb
import br.com.fiap.mentormatch.model.Users

class UserRepository (context: Context) {

    private val db = UserDb.getDatabase(context).userDao()

    fun save(user: Users): Long {
        return db.save(user)
    }

    fun update(user: Users): Int {
        return db.update(user)
    }

    fun delete(user: Users): Int {
        return db.delete(user)
    }

    fun listUsers(): List<Users> {
        return db.listUsers()
    }

    fun findUserById(id: Int): Users {
        return db.findUserById(id)
    }
}