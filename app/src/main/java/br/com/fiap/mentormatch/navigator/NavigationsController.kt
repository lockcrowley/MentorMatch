package br.com.fiap.mentormatch.navigator

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.animalmatchatt.navigator.Screens
import br.com.fiap.mentormatch.R.*
import br.com.fiap.mentormatch.components.HeaderComponent
import br.com.fiap.mentormatch.database.repository.UserRepository
import br.com.fiap.mentormatch.screens.adoptionProcess.ListUsersScreen
import br.com.fiap.mentormatch.screens.profile.ProfileScreen
import br.com.fiap.mentormatch.screens.profile.ProfileUsersScreen
import br.com.fiap.mentormatch.screens.userRegister.UsersRegisterScreen
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationController () {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    var screenWidth = LocalConfiguration.current.screenWidthDp.dp
    screenWidth /= 2

    val poppyns = FontFamily(
        Font(font.poppins_regular)
    )

    val contextUser = LocalContext.current
    val userRepository = UserRepository(contextUser)
    var userById = userRepository.findUserById(1)

    var initialScreen by remember {
        mutableStateOf("")
    }

    if (userById != null) {
        initialScreen = "ListUsersScreen"
    } else {
        initialScreen = "registeredUsers"
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet (
                modifier =  Modifier.width(screenWidth)
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                ){
                    Row () {
                        Text(
                            text = "Bem vindo, ",
                            color = colorResource(id = color.orange),
                            fontFamily = poppyns,
                            fontSize = 18.sp
                        )
                    }
                }

                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp)
                ) {
                    userById = userRepository.findUserById(1)
                    if (userById != null) {
                        Text(
                            text = userById.name,
                            color = colorResource(id = color.orange),
                            fontFamily = poppyns,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    } else {
                        Text(
                            text = "Usuário",
                            color = colorResource(id = color.orange),
                            fontFamily = poppyns,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    }
                }

                HorizontalDivider()
                //PROFILE
                NavigationDrawerItem(
                    label = { Text(
                        text = "Perfil",
                        fontFamily = poppyns,
                        modifier = Modifier
                            .offset(x = (-15).dp)
                    ) },
                    selected = false,
                    icon = {
                        Icon(
                            painter = painterResource(id = drawable.baseline_person_24),
                            contentDescription = "",
                            tint = colorResource(id = color.green_light),
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .offset(x = (-10).dp)
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        userById = userRepository.findUserById(1)

                        if (userById != null) {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Screens.ProfileScreen.screen) {
                                popUpTo(0)
                            }
                        } else {
                            Toast.makeText(context, "Por favor, crie uma conta!", Toast.LENGTH_SHORT).show()
                            navigationController.navigate(Screens.UsersRegisterScreen.screen) {
                                popUpTo(0)
                            }
                        }
                    }
                )

                //List USERS
                NavigationDrawerItem(
                    label = { Text(text = "Lista de usuários", fontFamily = poppyns, modifier = Modifier
                        .offset(x = (-15).dp)) },
                    selected = false,
                    icon = {
                        Icon(
                            painter = painterResource(id = drawable.baseline_people_24),
                            contentDescription = "",
                            tint = colorResource(id = color.green_light),
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .offset(x = (-10).dp)
                        )
                    },
                    onClick = {
                        userById = userRepository.findUserById(1)

                        if (userById != null) {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navigationController.navigate(Screens.ListUsersScreen.screen) {
                                popUpTo(0)
                            }
                        } else {
                            Toast.makeText(context, "Por favor, crie uma conta!", Toast.LENGTH_SHORT).show()
                            navigationController.navigate(Screens.UsersRegisterScreen.screen) {
                                popUpTo(0)
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(300.dp))

                //LOGOUT
                NavigationDrawerItem(
                    label = { Text(text = "Sair", fontFamily = poppyns, modifier = Modifier
                        .offset(x = (-15).dp)) },
                    selected = false,
                    icon = {
                        Icon(
                            painter = painterResource(id = drawable.baseline_logout_24),
                            contentDescription = "",
                            tint = colorResource(id = color.green_light),
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .offset(x = (-10).dp)
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        userById = userRepository.findUserById(1)

                        if (userById != null) {
                            Toast.makeText(context, "Logout - Conta excluida! Por favor, crie outra!", Toast.LENGTH_SHORT).show()
                            navigationController.navigate(Screens.UsersRegisterScreen.screen) {
                                popUpTo(0)
                            }
                            userRepository.delete(userById)
                        } else {
                            Toast.makeText(context, "Logout!", Toast.LENGTH_SHORT).show()
                            navigationController.navigate(Screens.UsersRegisterScreen.screen) {
                                popUpTo(0)
                            }
                        }
                    }
                )
            }
        }) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()

                HeaderComponent{
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }
            }
        ) {
            NavHost(
                navController = navigationController,
                startDestination = initialScreen,
            ) {
                composable(Screens.ProfileScreen.screen){ ProfileScreen()}
                composable(
                    Screens.ProfileUsersScreen.screen,
                    arguments = listOf(
                        navArgument(name = "userId") {
                            type = NavType.LongType
                        }
                    )
                ){
                    val userId = it.arguments?.getLong("userId") ?: 0
                    ProfileUsersScreen(userId)
                }
                composable(Screens.UsersRegisterScreen.screen){ UsersRegisterScreen(navigationController) }
                composable(Screens.ListUsersScreen.screen){ ListUsersScreen(navigationController) }
            }
        }
    }
}