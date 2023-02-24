package com.sawrose.marvel_showroom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sawrose.marvel_showroom.navigation.Navigation.Args.CHARACTER_ID

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Navigation.Routes.HOME
    ){
        composable(Navigation.Routes.HOME){
            HomeScreenDestination(navController = navController)
        }
//        composable(
//            route = Navigation.Routes.DETAIL,
//            arguments = listOf(navArgument(name = CHARACTER_ID) {
//                type = NavType.StringType
//            })
//        ){ backStackEntry ->
//            val characterId = requireNotNull(backStackEntry.arguments?.getString(CHARACTER_ID)) {
//                "Character id is required as Argument"
//            }
//            DetailScreenDestination(
//                characterId = characterId,
//                navController = navController
//            )
//        }
    }
}


object Navigation {
    object Args {
        const val CHARACTER_ID = "character_id"
    }
    object Routes {
        const val HOME = "home"
        const val DETAIL = "$HOME/{character_id}"
    }
}