package com.aakulovaa.vkedu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aakulovaa.vkedu.Routes
import com.aakulovaa.vkedu.presentation.layout.screens.AppDetailsScreen
import com.aakulovaa.vkedu.presentation.layout.screens.AppListScreen
import com.aakulovaa.vkedu.theme.VKeduTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        composable("${Routes.APP_DETAILS}/{idAppDetails}") { backStackEntry ->
            val idAppDetails = backStackEntry.arguments?.getString("idAppDetails")
            AppDetailsScreen(idAppDetails = idAppDetails!!, navController = navController)

        }
    }
}
