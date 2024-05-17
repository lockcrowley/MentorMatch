package br.com.fiap.mentormatch.utils

import androidx.room.TypeConverter
import br.com.fiap.mentormatch.model.Users
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//Função para Converter uma lista para o Room

object Converters {
    @TypeConverter
    @JvmStatic
    fun fromJson(json: String): List<Users> {
        val listType = object : TypeToken<List<Users>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    @JvmStatic
    fun toJson(list: List<Users>): String {
        return Gson().toJson(list)
    }
}
