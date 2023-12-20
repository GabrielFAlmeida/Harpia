package com.example.harpia.navigation

import com.example.harpia.domain.constants.ABOUT_SCREEN
import com.example.harpia.domain.constants.EXPERIENCE_RESULT_SCREEN
import com.example.harpia.domain.constants.HOME_SCREEN
import com.example.harpia.domain.constants.LOGIN_SCREEN
import com.example.harpia.domain.constants.METHODOLOGIES_SCREEN
import com.example.harpia.domain.constants.NEW_EXPERIENCE_SCREEN
import com.example.harpia.domain.constants.PASSWORD_SCREEN
import com.example.harpia.domain.constants.PROFILE_SCREEN
import com.example.harpia.domain.constants.SEARCH_EXPERIENCE_SCREEN
import com.example.harpia.domain.constants.SIGNUP_SCREEN
import com.example.harpia.domain.constants.TEAM_SCREEN

sealed class Screen(val route: String) {
    object SignUpScreen : Screen(SIGNUP_SCREEN)
    object LoginScreen : Screen(LOGIN_SCREEN)
    object PasswordScreen : Screen(PASSWORD_SCREEN)
    object AboutScreen : Screen(ABOUT_SCREEN)
    object TeamScreen : Screen(TEAM_SCREEN)
    object HomeScreen : Screen(HOME_SCREEN)
    object NewExperienceScreen : Screen(NEW_EXPERIENCE_SCREEN)
    object SearchExperienceScreen : Screen(SEARCH_EXPERIENCE_SCREEN)
    object ExperienceResultScreen : Screen(EXPERIENCE_RESULT_SCREEN)
    object MethodologiesScreen : Screen(METHODOLOGIES_SCREEN)
    object ProfileScreen : Screen(PROFILE_SCREEN)

    fun withMandatoryArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}