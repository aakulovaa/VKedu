package com.aakulovaa.vkedu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aakulovaa.vkedu.Routes
import com.aakulovaa.vkedu.data.models.AppListItem
import com.aakulovaa.vkedu.presentation.components.AppCard
import com.aakulovaa.vkedu.presentation.components.AppListScreenHeader
import com.aakulovaa.vkedu.presentation.components.apps
import com.aakulovaa.vkedu.toListItem
import com.aakulovaa.vkedu.ui.theme.VKeduTheme


@Composable
fun AppListScreen(apps: List<AppListItem>, navController: NavController){
    Column (modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary)){

        AppListScreenHeader()

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            color = MaterialTheme.colorScheme.onPrimary
        ) {
            LazyColumn {
                items(apps) { app ->
                    AppCard(appItem = app,
                        onClick = {
                            navController.navigate(Routes.appDetails(app.title))
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
            apps.map { it.toListItem() },
            navController = rememberNavController()
        )
    }

}