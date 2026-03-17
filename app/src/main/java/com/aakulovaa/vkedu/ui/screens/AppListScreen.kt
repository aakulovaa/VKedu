package com.aakulovaa.vkedu.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aakulovaa.vkedu.R
import com.aakulovaa.vkedu.Routes
import com.aakulovaa.vkedu.data.models.AppListItem
import com.aakulovaa.vkedu.presentation.components.AppCard
import com.aakulovaa.vkedu.presentation.components.AppListScreenHeader
import com.aakulovaa.vkedu.presentation.components.state.AppListState
import com.aakulovaa.vkedu.presentation.components.viewModel.AppListViewModel
import com.aakulovaa.vkedu.ui.theme.VKeduTheme


@Composable
fun AppListScreen(navController: NavController){
    val viewModel: AppListViewModel = viewModel ()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is AppListState.AppListContent -> {
            AppListScreenContent(currentState.apps, navController)
        }
        AppListState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(
                    text = stringResource(R.string.error_loading_app_list),
                    color = MaterialTheme.colorScheme.error
                    )
            }
        }
        AppListState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
private fun AppListScreenContent(appList: List<AppListItem>, navController: NavController, modifier: Modifier = Modifier){
    Column (modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary)){

        AppListScreenHeader()

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            color = MaterialTheme.colorScheme.onPrimary
        ) {
            LazyColumn {
                items(appList) { app ->
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
            navController = rememberNavController()
        )
    }

}