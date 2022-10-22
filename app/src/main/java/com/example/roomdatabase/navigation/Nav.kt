package com.example.roomdatabase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomdatabase.ui.update.UpdateUser


@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {
        composable(route = "list") {
            List(navController)
        }
        composable(route = "addUser") {
            AddUserUi(navController)
        }
        composable(
            route = "update/{id}/{fName}/{lName}/{age}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                },
                navArgument(name = "fName") {
                    type = NavType.StringType
                },
                navArgument(name = "lName") {
                    type = NavType.StringType
                },
                navArgument(name = "age") {
                    type = NavType.IntType
                }
            )
        ) {
            // get id to update which item we are selected
            UpdateUser(
                navController,
                it.arguments?.getInt("id"),
                it.arguments?.getString("fName"),
                it.arguments?.getString("lName"),
                it.arguments?.getInt("age")
            )
        }


    }
}