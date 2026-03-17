package com.aakulovaa.vkedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aakulovaa.vkedu.ui.screens.AppDetailsScreen
import com.aakulovaa.vkedu.ui.screens.AppListScreen
import com.aakulovaa.vkedu.ui.theme.VKeduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKeduTheme {
                NavGraph()
            }
        }
    }
}

@Composable
fun NavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.APP_LIST) {
        composable(Routes.APP_LIST) {
            AppListScreen(navController = navController)
        }

        composable("${Routes.APP_DETAILS}/{appTitle}") { backStackEntry ->
            val appTitle = backStackEntry.arguments?.getString("appTitle") ?: ""
            AppDetailsScreen(title = appTitle, navController = navController)

        }
    }
}
