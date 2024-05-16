package br.com.fiap.mentormatch.screens.userRegister

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentormatch.R.*
import br.com.fiap.mentormatch.components.ButtonComponent
import br.com.fiap.mentormatch.components.TextFieldComponent
import br.com.fiap.mentormatch.components.TitleComponent
import br.com.fiap.mentormatch.database.repository.UserRepository
import br.com.fiap.mentormatch.model.Users
import androidx.navigation.NavController

@Composable
fun UsersRegisterScreen(navigationController: NavController) {

    var userName by remember() {
        mutableStateOf("")
    }

    var userExperiencies by remember {
        mutableStateOf("")
    }

    var userSkills by remember {
        mutableStateOf("")
    }

    var userPhone by remember {
        mutableStateOf("")
    }

    var userJob by remember {
        mutableStateOf("")
    }

    var userLocale by remember {
        mutableStateOf("")
    }

    var isMentor by remember {
        mutableStateOf(-1)
    }

    var errorName by remember {
        mutableStateOf(false)
    }

    var errorPhone by remember {
        mutableStateOf(false)
    }

    var errorjob by remember {
        mutableStateOf(false)
    }

    var mentorOrstudent = isMentor == 0

    val context = LocalContext.current
    val userRepository = UserRepository(context)

    val user = Users(
        id = 1,
        name = userName,
        experiencies = userExperiencies,
        skills = userSkills,
        phone = userPhone,
        job = userJob,
        locale = userLocale,
        isMentor = mentorOrstudent
    )

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            TitleComponent(
                title = "Cadastre-se",
                colorText = color.gray_title,
                nameProfileFontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = color.green_bold)),
        ) {

            LazyColumn() {
                item {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(50.dp))

                        TextFieldComponent(
                            fieldValue = userName,
                            onFieldChange = {
                                userName = it
                            },
                            placeholderValue =  "Nome",
                            iconImage = painterResource(id = drawable.baseline_person_24),

                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        TextFieldComponent(
                            fieldValue = userExperiencies,
                            onFieldChange = {
                                userExperiencies = it
                            },
                            placeholderValue =  "Experiencia",
                            iconImage = painterResource(id = drawable.baseline_auto_awesome_24)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        TextFieldComponent(
                            fieldValue = userSkills,
                            onFieldChange = {
                                userSkills = it
                            },
                            placeholderValue =  "Habilidades - ex: proativo, liderança",
                            iconImage = painterResource(id = drawable.baseline_extension_24)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        TextFieldComponent(
                            fieldValue = userPhone,
                            onFieldChange = {
                                userPhone = it
                            },
                            placeholderValue =  "Celular",
                            iconImage = painterResource(id = drawable.baseline_phone_android_24)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        TextFieldComponent(
                            fieldValue = userJob,
                            onFieldChange = {
                                userJob = it
                            },
                            placeholderValue =  "Trabalho - ex: Programador",
                            iconImage = painterResource(id = drawable.baseline_work_24)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        TextFieldComponent(
                            fieldValue = userLocale,
                            onFieldChange = {
                                userLocale = it
                            },
                            placeholderValue =  "Localização - ex: SP, São Paulo",
                            iconImage = painterResource(id = drawable.baseline_map_24)
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Row (verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = isMentor == 0,
                                onClick = {
                                    isMentor = 0
                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Black,
                                    unselectedColor = Color(0xFFFFFFFF)
                                )
                            )
                            Text(text = "Mentor", color = colorResource(id = color.white))

                            RadioButton(
                                selected = isMentor == 1,
                                onClick = {
                                    isMentor = 1
                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.Black,
                                    unselectedColor = Color(0xFFFFFFFF)
                                )
                            )
                            Text(text = "Aluno", color = colorResource(id = color.white))
                        }

                        Spacer(modifier = Modifier.height(45.dp))

                        ButtonComponent(
                            textField = "Cadastrar",
                            fontTextButton = 20.sp,
                            colorButton = color.orange,
                            user = user,
                            userRepository = userRepository,
                            navigationController = navigationController
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

