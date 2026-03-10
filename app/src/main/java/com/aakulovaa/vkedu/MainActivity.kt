package com.aakulovaa.vkedu

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aakulovaa.vkedu.ui.screens.MainScreen
import com.aakulovaa.vkedu.ui.theme.VKeduTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKeduTheme {
                MainScreen(
                    openSecondActivity = { text ->
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putExtra("EXTRA_TEXT", text)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}
