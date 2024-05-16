package br.com.fiap.mentormatch.screens.adoptionProcess

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentormatch.R.*
import androidx.compose.material3.CardDefaults
import androidx.navigation.NavController
import br.com.fiap.mentormatch.components.ProfileImageComponent
import br.com.fiap.mentormatch.components.TitleComponent
import br.com.fiap.mentormatch.database.repository.UserRepository
import br.com.fiap.mentormatch.repository.getAllUsers
import br.com.fiap.mentormatch.repository.getAllUsersBySearch

@Composable
fun ListUsersScreen (navigationController: NavController) {
    var searchTextState by remember {
        mutableStateOf("")
    }

    var listUsers by remember {
        mutableStateOf(getAllUsersBySearch(searchTextState))
    }

    val poppyns = FontFamily(
        Font(font.poppins_regular)
    )

    val context = LocalContext.current
    val userRepository = UserRepository(context)

    Column (
        modifier = Modifier.padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Box(
            modifier = Modifier.padding(vertical = 10.dp)
        ){
            TitleComponent(
                title = "Usuários para se conectar",
                colorText = color.orange,
                nameProfileFontSize = 25.sp
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Box{
            OutlinedTextField(
                value = searchTextState,
                onValueChange = {
                    searchTextState = it
                    listUsers = getAllUsersBySearch(searchTextState)
                },
                modifier = Modifier
                    .width(330.dp)
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = color.orange),
                    focusedBorderColor = colorResource(id = color.orange)
                ),
                placeholder = {
                    Text(
                        text = "Procure pelos Mentores/Alunos",
                        fontFamily = poppyns,
                        color = colorResource(id = color.gray_title)
                    )
                },
                trailingIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = colorResource(id = color.gray_title)
                        )
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEBEEEB)
            )
        ){
            Column {
                LazyColumn(
                    modifier = Modifier
                        .offset(x = (60).dp)
                ) {
                    items(getAllUsers().chunked(2)) {
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
                                    button = true,
                                    nav = navigationController,
                                    userId = user.id
                                )

                                Spacer(modifier = Modifier.width(30.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}