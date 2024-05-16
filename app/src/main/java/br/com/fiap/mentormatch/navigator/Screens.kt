package br.com.fiap.animalmatchatt.navigator

sealed class Screens (val screen: String) {
    data object ProfileScreen: Screens("profile")
    data object ProfileUsersScreen: Screens("profileUsers/{userId}")
    data object UsersRegisterScreen: Screens("registeredUsers")
    data object ListUsersScreen: Screens("ListUsersScreen")
}