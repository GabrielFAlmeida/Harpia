package com.example.harpia.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{

    object LoginScreen: Screen()
    object SignUpScreen: Screen()
    object PasswordScreen: Screen()
    object AboutScreen: Screen()
    object TeamScreen: Screen()
    object HomeScreen: Screen()
    object MethodologiesScreen: Screen()
    object ExperienceResultScreen: Screen()
    object NewExperienceScreen: Screen()
    object ProfileScreen: Screen()
    object SearchExperienceScreen: Screen()
}

object HarpiaAppRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}