package com.aakulovaa.vkedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aakulovaa.vkedu.presentation.components.apps
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

    NavHost(navController = navController, startDestination = "app_list") {
        composable("app_list") {
            AppListScreen(apps = apps, navController = navController)
        }

        composable("app_details/{appTitle}") { backStackEntry ->
            val appTitle = backStackEntry.arguments?.getString("appTitle")
            val app = apps.find { it.title == appTitle }
            if (app != null) {
                AppDetailsScreen(app = app, navController = navController)
            }
        }
    }
}
