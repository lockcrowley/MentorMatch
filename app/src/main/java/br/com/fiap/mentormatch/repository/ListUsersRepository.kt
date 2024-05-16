package br.com.fiap.mentormatch.repository

import br.com.fiap.mentormatch.model.Users
import br.com.fiap.mentormatch.R.*

fun getAllUsers(): List<Users> {

    return listOf(
        Users(id = 1, name = "Carlos", locale = "SP, Sao Paulo", experiencies = "Professor", skills = "Proativo", phone = "11988323029", job = "Professor de engenharia", imageUser = drawable.man_florest, isMentor = false),
        Users(id = 2, name = "Jorge", locale = "SP, Sao Paulo", experiencies = "Programador", skills = "Trabalho em equipe", phone = "11988323029", job = "Analista de sistemas", imageUser = drawable.man_dark, isMentor = true),
        Users(id = 4, name = "Thor", locale = "SP, Sao Paulo", experiencies = "Analista", skills = "Proativo", phone = "11920304950", job = "Engenheiro de dados", imageUser = drawable.avatar, isMentor = false),
        Users(id = 5, name = "Olivia", locale = "MG, Belo Horizonte", experiencies = "PO", skills = "Pontual", phone = "11988323029", job = "Programador Python", imageUser = drawable.girl_montain, isMentor = false),
        Users(id = 6, name = "Melina", locale = "SP, Sao Paulo", experiencies = "Programador", skills = "Frontend", phone = "11988323029", job = "Desenvolvedor de software", imageUser = drawable.girl_photo, isMentor = true),
        Users(id = 7, name = "Pamela", locale = "BA, Salvador", experiencies = "Analista", skills = "Trabalho em equipe", phone = "11940506070", job = "Engenheiro de software", imageUser = drawable.girl_morning, isMentor = true),
        Users(id = 8, name = "Luna", locale = "RJ, Rio de Janeiro", experiencies = "Scrum", skills = "Proativo", phone = "11920304050", job = "Analista de sistemas", imageUser = drawable.girl_red, isMentor = false),
        Users(id = 9, name = "Rafael", locale = "SP, Sao Paulo", experiencies = "Gestor", skills = "Proativo", phone = "11920304050", job = "Professor de TI", imageUser = drawable.man_draw, isMentor = false),
        Users(id = 10, name = "Diogo", locale = "SP, Sao Paulo", experiencies = "Scrum", skills = "Trabalhador", phone = "11920304050", job = "Coordenador", imageUser = drawable.man, isMentor = true),
        Users(id = 11, name = "Rob", locale = "SP, Osasco", experiencies = "Scrum", skills = "Trabalho em equipe", phone = "99999999999", job = "Analista de sistemas", imageUser = drawable.avatar, isMentor = false),
        Users(id = 12, name = "Lari", locale = "SP, Sao Paulo", experiencies = "Gestor", skills = "Proativo", phone = "11920304050", job = "Professor de TI", imageUser = drawable.avatar, isMentor = false),
        Users(id = 13, name = "Bruno", locale = "SP, Sao Paulo", experiencies = "Scrum", skills = "Trabalhador", phone = "11920304050", job = "Coordenador", imageUser = drawable.avatar, isMentor = true)
    )
}

fun getAllUsersBySearch(name: String): List<Users>{
    return getAllUsers().filter {
        it.name.startsWith(prefix = name, ignoreCase = true)
//        it.type.startsWith(prefix = type, ignoreCase = true)
//        it.race.startsWith(prefix = race, ignoreCase = true)
    }
}

fun getAllUsersBySearchId(id: Long): Users? {
    return getAllUsers().find {
        it.id == id
    }
}