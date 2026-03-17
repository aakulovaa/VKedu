package com.aakulovaa.vkedu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aakulovaa.vkedu.R

@Composable
fun AppListScreenHeader(onLogoClick: ()-> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp, bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(R.drawable.rustore),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
                .clickable{onLogoClick()}
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = stringResource(R.string.app_logo),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.grid),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}