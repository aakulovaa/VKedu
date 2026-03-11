package com.aakulovaa.vkedu.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aakulovaa.vkedu.R
import com.aakulovaa.vkedu.ui.theme.Blue
import com.aakulovaa.vkedu.ui.theme.White

@Composable
fun AppListScreenHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Blue)
            .padding(horizontal = 16.dp)
            .padding(top = 80.dp, bottom = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(R.drawable.rustore),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "RuStore",
            color = White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(R.drawable.grid),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = Color.White
        )
    }
}