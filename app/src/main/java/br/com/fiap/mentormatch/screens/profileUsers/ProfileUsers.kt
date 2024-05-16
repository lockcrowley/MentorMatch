package br.com.fiap.mentormatch.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentormatch.R.*
import br.com.fiap.mentormatch.components.ProfileImageComponent
import br.com.fiap.mentormatch.database.repository.UserRepository
import br.com.fiap.mentormatch.repository.getAllUsers
import br.com.fiap.mentormatch.repository.getAllUsersBySearchId

@Composable

fun ProfileUsersScreen(userId: Long) {
    val poppyns = FontFamily(
        Font(font.poppins_regular)
    )

    val userById = getAllUsersBySearchId(userId)


    var userIsMentor by remember {
        mutableStateOf("")
    }

    if (userById!!.isMentor) {
        userIsMentor = "Mentor"
    } else {
        userIsMentor = "Aluno"
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 60.dp)
    ) {

        Box(modifier = Modifier
            .padding(20.dp)
            .offset(y = (-10).dp)) {
            Row () {
                ProfileImageComponent(
                    imageProfile = drawable.avatar,
                    description = "User",
                    sizeImage = 100.dp,
                    imageBorderColor = color.green_light,
                    borderWidth = 4.dp,
                    button = false,
                    nav = false,
                    userId = userById.id
                )

                Box(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Column {
                        Text(
                            text = userById.name,
                            color = colorResource(id = color.gray_title),
                            fontFamily = poppyns,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = userById.job,
                            color = colorResource(id = color.gray_title),
                            fontFamily = poppyns,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.offset(y = (-20).dp)
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .offset(y = (-65).dp, x = (-55).dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Menu Icon",
                    tint = colorResource(id = color.green_light),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = userById.name,
                    color = colorResource(id = color.gray_title),
                    fontFamily = poppyns,
                    fontSize = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Menu Icon",
                    tint = colorResource(id = color.green_light),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = userById.locale,
                    color = colorResource(id = color.gray_title),
                    fontFamily = poppyns,
                    fontSize = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Menu Icon",
                    tint = colorResource(id = color.green_light),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = userById.phone,
                    color = colorResource(id = color.gray_title),
                    fontFamily = poppyns,
                    fontSize = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Menu Icon",
                    tint = colorResource(id = color.green_light),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = userById.job,
                    color = colorResource(id = color.gray_title),
                    fontFamily = poppyns,
                    fontSize = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Menu Icon",
                    tint = colorResource(id = color.green_light),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = userById.skills,
                    color = colorResource(id = color.gray_title),
                    fontFamily = poppyns,
                    fontSize = 17.sp
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Menu Icon",
                    tint = colorResource(id = color.green_light),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = userIsMentor,
                    color = colorResource(id = color.gray_title),
                    fontFamily = poppyns,
                    fontSize = 17.sp
                )
            }
        }

        Box (
            modifier = Modifier
                .padding(horizontal = 55.dp)
                .height(20.dp)
                .width(310.dp)
                .offset(y = (-50).dp)
        )

        Box (
            modifier = Modifier
                .padding(horizontal = 50.dp)
                .offset(y = (-65).dp, x = (-48).dp)
        ) {
            Row (verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = drawable.baseline_arrow_drop_down_circle_24),
                    contentDescription = "Icon arrow down",
                    tint = colorResource(id = color.orange),
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )

                Text(
                    text = "Usuários conectados",
                    color = colorResource(id = color.orange),
                    fontFamily = poppyns,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            LazyColumn(
                modifier = Modifier
                    .offset(y = (-40).dp, x = (18).dp)
            ) {
                items(getAllUsers().chunked(3)) {
                    Row (horizontalArrangement = Arrangement.SpaceAround) {
                        for (user in it) {
                            ProfileImageComponent(
                                imageProfile = user.imageUser,
                                description = user.name,
                                sizeImage = 70.dp,
                                imageBorderColor = color.green_light,
                                borderWidth = 2.dp,
                                nameProfile = user.name,
                                nameProfileFontSize = 12.sp,
                                button = false,
                                nav = false,
                                userId = user.id
                            )

                            Spacer(modifier = Modifier.width(30.dp))
                        }
                    }
                }
            }
        }
    }

    Box (
        modifier = Modifier
            .offset(y = (620).dp, x = (145).dp)
    ) {
        Icon(
            painter = painterResource(id = drawable.baseline_arrow_downward_24),
            contentDescription = "",
            tint = colorResource(id = color.gray_title),
        )
    }

    Box (
        modifier = Modifier
            .offset(y = (620).dp, x = (245).dp)
    ) {
        Icon(
            painter = painterResource(id = drawable.baseline_arrow_downward_24),
            contentDescription = "",
            tint = colorResource(id = color.gray_title),
        )
    }
}