package com.aakulovaa.vkedu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aakulovaa.vkedu.ui.screens.SecondScreen
import com.aakulovaa.vkedu.ui.theme.VKeduTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedText = intent.getStringExtra("EXTRA_TEXT") ?: getString(R.string.error_receiving_text)

        setContent {
            VKeduTheme {
                SecondScreen(
                    receivedText = receivedText,
                    onBackClick = { finish() }
                )
            }
        }
    }
}