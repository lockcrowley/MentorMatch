package br.com.fiap.mentormatch.model

import br.com.fiap.mentormatch.R.*

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class Users(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String = "",
    var experiencies: String = "",
    var skills: String = "",
    var phone: String = "",
    var job: String = "",
    var locale: String = "",
    var availability: String = "Disponivel",
    @ColumnInfo(name = "image_user") var imageUser: Int = drawable.avatar,
    @ColumnInfo(name = "is_mentor") var isMentor: Boolean = false,
    @ColumnInfo(name = "contacts") var contacts: List<Users> = listOf()
)
