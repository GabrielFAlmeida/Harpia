package com.example.harpia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.harpia.screens.AboutScreen
import com.example.harpia.screens.ExperienceResultScreen
import com.example.harpia.screens.HomeScreen
import com.example.harpia.screens.LoginScreen
import com.example.harpia.screens.MethodologiesScreen
import com.example.harpia.screens.NewExperienceScreen
import com.example.harpia.screens.PasswordScreen
import com.example.harpia.screens.ProfileScreen
import com.example.harpia.screens.SearchExperienceScreen
import com.example.harpia.screens.SignUpScreen
import com.example.harpia.screens.TeamScreen
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable
fun HarpiaAppNavGraph(navController: NavHostController) {

    val database = Firebase.firestore //Caminho para encontrar o banco na nuvem.

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(Screen.PasswordScreen.route) {
            PasswordScreen(navController)
        }

        composable(Screen.AboutScreen.route) {
            AboutScreen(navController)
        }

        composable(Screen.TeamScreen.route) {
            TeamScreen(navController)
        }

        composable(Screen.NewExperienceScreen.route) {
            NewExperienceScreen(navController, database)
        }

        composable(Screen.SearchExperienceScreen.route) {
            SearchExperienceScreen(navController)
        }

        composable(
            Screen.ExperienceResultScreen.route + "/{experienceSearchKeyword}/{experienceSearchMethodology}/{experienceSearchSchoolClass}",
            listOf(
                navArgument("experienceSearchKeyword") {
                    type = NavType.StringType
                    nullable = false
                },
                navArgument("experienceSearchMethodology") {
                    type = NavType.StringType
                    nullable = false
                },
                navArgument("experienceSearchSchoolClass") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { navBackStackEntry ->
            val experienceSearchKeyword =
                navBackStackEntry.arguments?.getString("experienceSearchKeyword")!!
            val experienceSearchMethodology =
                navBackStackEntry.arguments?.getString("experienceSearchMethodology")!!
            val experienceSearchSchoolClass =
                navBackStackEntry.arguments?.getString("experienceSearchSchoolClass")!!
            ExperienceResultScreen(
                navController,
                database,
                experienceSearchKeyword,
                experienceSearchMethodology,
                experienceSearchSchoolClass
            )
        }

        composable(Screen.MethodologiesScreen.route) {
            MethodologiesScreen(navController, database)
        }

        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController)
        }
    }
}