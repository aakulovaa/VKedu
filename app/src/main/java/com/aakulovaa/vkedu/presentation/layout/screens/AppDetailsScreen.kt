package com.aakulovaa.vkedu.presentation.layout.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aakulovaa.vkedu.R
import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.model.Category
import com.aakulovaa.vkedu.presentation.layout.detailScreen.AppDescription
import com.aakulovaa.vkedu.presentation.layout.detailScreen.AppDetailsHeader
import com.aakulovaa.vkedu.presentation.layout.detailScreen.Developer
import com.aakulovaa.vkedu.presentation.layout.detailScreen.InstallButton
import com.aakulovaa.vkedu.presentation.layout.detailScreen.ScreenshotsList
import com.aakulovaa.vkedu.presentation.layout.detailScreen.Toolbar
import com.aakulovaa.vkedu.presentation.viewModel.AppDetailsViewModel
import com.aakulovaa.vkedu.presentation.viewModel.state.AppDetailsState
import com.aakulovaa.vkedu.theme.VKeduTheme

@Composable
fun AppDetailsScreen(navController: NavController,
                     modifier: Modifier = Modifier
) {
    val viewModel: AppDetailsViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is AppDetailsState.Content -> {
            AppDetailsContent(currentState.appDetails, navController,
                onWishListClick = {
                    viewModel.toggleWishlist()
                }
            )

        }
        AppDetailsState.Error -> {
            ErrorMessage(stringResource(R.string.error_loading_app_details))
        }
        AppDetailsState.Loading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
    }

}

@Composable
private fun ErrorMessage(message: String){
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
private fun AppDetailsContent(appDetails: AppDetails, navController: NavController, onWishListClick: () -> Unit, modifier: Modifier = Modifier){
    val context = LocalContext.current
    val underDevelopmentText = stringResource(R.string.under_developement)
    var descriptionCollapsed by remember { mutableStateOf(false) }

    Column(modifier.padding(vertical = 32.dp)) {
        Toolbar(
            isInWishlist = appDetails.isInWishlist,
            onBackClick = {
                navController.popBackStack()
            },
            onShareClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            onWishlistClick = {
                onWishListClick()
                val message = if (!appDetails.isInWishlist) {
                    context.getString(R.string.add_wishlist)
                } else {
                    context.getString(R.string.remove_wishlist)
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        )

        Spacer(Modifier.height(8.dp))

        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(Modifier.height(16.dp))

        InstallButton(
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(Modifier.height(12.dp))
        ScreenshotsList(
            screenshotUrlList = appDetails.screenshotUrlList,
            contentPadding = PaddingValues(horizontal = 16.dp),
        )

        Spacer(Modifier.height(12.dp))

        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = {
                descriptionCollapsed = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )

        Spacer(Modifier.height(12.dp))

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )

        Spacer(Modifier.height(12.dp))

        Developer(
            name = appDetails.developer,
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AppDetailsScreenPreview() {

    val previewApp = AppDetails(
        id = "1",
        title = "СберБанк Онлайн — с Салютом",
        developer = "Сбербанк",
        description = "Больше чем банк",
        category = Category.FINANCE,
        iconUrl = "https://static.rustore.ru/apk/462271/content/ICON/f1b3c68a-b734-48ce-b62f-490208d3fa0e.png",
        ageRating = 3,
        size = 45.6f,
        screenshotUrlList = emptyList(),
        isInWishlist = false
    )

    VKeduTheme {
        AppDetailsContent(
            appDetails = previewApp,
            navController = rememberNavController(),
            onWishListClick = { },
            modifier = Modifier.fillMaxSize()
        )
    }
}