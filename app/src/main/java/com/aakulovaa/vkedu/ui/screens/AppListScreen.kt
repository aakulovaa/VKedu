package com.aakulovaa.vkedu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aakulovaa.vkedu.data.models.App
import com.aakulovaa.vkedu.presentation.components.AppCard
import com.aakulovaa.vkedu.presentation.components.AppListScreenHeader
import com.aakulovaa.vkedu.presentation.components.apps
import com.aakulovaa.vkedu.ui.theme.Blue
import com.aakulovaa.vkedu.ui.theme.VKeduTheme


@Composable
fun AppListScreen(apps: List<App>, navController: NavController){
    Column (modifier = Modifier.fillMaxSize().background(Blue)){

        AppListScreenHeader()

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            color = Color.White
        ) {
            LazyColumn {
                items(apps) { app ->
                    AppCard(appItem = app,
                        onClick = {
                            navController.navigate("app_details/${app.title}")
                        }
                    )
                }
            }
        }

    }
}

@Preview
@Composable
private fun Preview(){
    VKeduTheme {
        AppListScreen(
            apps,
            navController = rememberNavController()
        )
    }

}