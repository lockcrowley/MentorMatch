package br.com.fiap.mentormatch.repository

import br.com.fiap.mentormatch.model.Users
import br.com.fiap.mentormatch.R.*

fun getAllUsers(): List<Users> {

    return listOf(
        Users(
            id = 1,
            name = "Carlos",
            locale = "SP, Sao Paulo",
            experiencies = "Professor",
            skills = "Proativo",
            phone = "11988323029",
            job = "Professor(a) de engenharia",
            availability = "Disponivel",
            imageUser = drawable.man_florest,
            isMentor = false,
            contacts = listOf(
                Users(
                    id = 2,
                    name = "Jorge",
                    locale = "SP, Sao Paulo",
                    experiencies = "Programador",
                    skills = "Trabalho em equipe",
                    phone = "11988323029",
                    job = "Analista de sistemas",
                    availability = "Disponivel",
                    imageUser = drawable.man_draw,
                    isMentor = true
                ),
                Users(
                    id = 4,
                    name = "Thor",
                    locale = "SP, Sao Paulo",
                    experiencies = "Analista",
                    skills = "Proativo",
                    phone = "11920304950",
                    job = "Engenheiro(a) de dados",
                    availability = "Disponivel",
                    imageUser = drawable.avatar,
                    isMentor = false
                )
            )
        ),

        Users(
            id = 2,
            name = "Jorge",
            locale = "SP, Sao Paulo",
            experiencies = "Programador",
            skills = "Trabalho em equipe",
            phone = "11988323029",
            job = "Analista de sistemas",
            availability = "Ausente",
            imageUser = drawable.man_draw,
            isMentor = true,
            contacts = listOf(
                Users(
                    id = 1,
                    name = "Carlos",
                    locale = "SP, Sao Paulo",
                    experiencies = "Professor",
                    skills = "Proativo",
                    phone = "11988323029",
                    job = "Professor(a) de engenharia",
                    availability = "Disponivel",
                    imageUser = drawable.man_florest,
                    isMentor = false
                ),
                Users(
                    id = 4,
                    name = "Thor",
                    locale = "SP, Sao Paulo",
                    experiencies = "Analista",
                    skills = "Proativo",
                    phone = "11920304950",
                    job = "Engenheiro(a) de dados",
                    availability = "Disponivel",
                    imageUser = drawable.avatar,
                    isMentor = false
                ),
                Users(
                    id = 8,
                    name = "Luna",
                    locale = "RJ, Rio de Janeiro",
                    experiencies = "Scrum",
                    skills = "Proativo",
                    phone = "11920304050",
                    job = "Analista de sistemas",
                    availability = "Offline",
                    imageUser = drawable.avatar,
                    isMentor = false
                ),
            )
        ),


        Users(id = 4, name = "Thor", locale = "SP, Sao Paulo", experiencies = "Analista", skills = "Proativo", phone = "11920304950", job = "Engenheiro(a) de dados", availability = "Disponivel", imageUser = drawable.avatar, isMentor = false, contacts = listOf()),

        Users(id = 5, name = "Olivia", locale = "MG, Belo Horizonte", experiencies = "PO", skills = "Pontual", phone = "11988323029", job = "Programador(a) Python", availability = "Ausente", imageUser = drawable.gilr_mon, isMentor = false, contacts = listOf()),

        Users(id = 6, name = "Melina", locale = "SP, Sao Paulo", experiencies = "Programador", skills = "Frontend", phone = "11988323029", job = "Desenvolvedor(a) de software", availability = "Ausente", imageUser = drawable.avatar, isMentor = true, contacts = listOf()),

        Users(id = 7, name = "Pamela", locale = "BA, Salvador", experiencies = "Analista", skills = "Trabalho em equipe", phone = "11940506070", job = "Engenheiro(a) de software", availability = "Disponivel", imageUser = drawable.gilr_summer, isMentor = true, contacts = listOf()),

        Users(id = 8, name = "Luna", locale = "RJ, Rio de Janeiro", experiencies = "Scrum", skills = "Proativo", phone = "11920304050", job = "Analista de sistemas", availability = "Offline", imageUser = drawable.girl_morning, isMentor = false, contacts = listOf()),

        Users(id = 9, name = "Rafael", locale = "SP, Sao Paulo", experiencies = "Gestor", skills = "Proativo", phone = "11920304050", job = "Professor(a) de TI", availability = "Disponivel", imageUser = drawable.man_thinking, isMentor = true, contacts = listOf()),

        Users(id = 10, name = "Diogo", locale = "SP, Sao Paulo", experiencies = "Scrum", skills = "Trabalhador", phone = "11920304050", job = "Coordenador(a)", availability = "Offline", imageUser = drawable.avatar, isMentor = true, contacts = listOf()),

        Users(id = 11, name = "Rob", locale = "SP, Osasco", experiencies = "Scrum", skills = "Trabalho em equipe", phone = "99999999999", job = "Analista de sistemas", availability = "Offline", imageUser = drawable.avatar, isMentor = false, contacts = listOf()),

        Users(
            id = 12,
            name = "Lari",
            locale = "SP, Sao Paulo",
            experiencies = "Gestor",
            skills = "Proativo",
            phone = "11920304050",
            job = "Professor(a) de TI",
            availability = "Disponivel",
            imageUser = drawable.avatar,
            isMentor = false,
            contacts = listOf(
                Users(
                    id = 10,
                    name = "Diogo",
                    locale = "SP, Sao Paulo",
                    experiencies = "Scrum",
                    skills = "Trabalhador",
                    phone = "11920304050",
                    job = "Coordenador(a)",
                    availability = "Offline",
                    imageUser = drawable.avatar,
                    isMentor = true
                ),
                Users(
                    id = 11,
                    name = "Rob",
                    locale = "SP, Osasco",
                    experiencies = "Scrum",
                    skills = "Trabalho em equipe",
                    phone = "99999999999",
                    job = "Analista de sistemas",
                    availability = "Offline",
                    imageUser = drawable.avatar,
                    isMentor = false
                ),
            )
        ),

        Users(id = 13, name = "Bruno", locale = "SP, Sao Paulo", experiencies = "Scrum", skills = "Trabalhador", phone = "11920304050", job = "Coordenador(a)", availability = "Disponivel", imageUser = drawable.man_morning, isMentor = true, contacts = listOf())
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