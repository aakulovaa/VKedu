package com.aakulovaa.vkedu.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.aakulovaa.vkedu.R

@Composable
fun MainScreen(
    openSecondActivity: (String) -> Unit
){
    var text by remember { mutableStateOf("") }
    var isPhoneError by remember { mutableStateOf(false) }
    val context = LocalContext.current

    fun isValidPhone(phone: String): Boolean {
        val cleaned = phone.replace(" ", "")
        return (cleaned.startsWith("+7") && cleaned.length == 12) || (cleaned.startsWith("8") && cleaned.length == 11)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                    isPhoneError = false },
                label = { Text(stringResource(R.string.input_text)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = isPhoneError
            )
            if (isPhoneError) {
                Text(
                    text = stringResource(R.string.error_phone_number),
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    if (text.isNotBlank()) {
                        openSecondActivity(text)
                    }
                },
                enabled = text.isNotBlank()
            ) {
                Text(stringResource(R.string.btn_open_second_activity))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val phone = text.trim()
                    if (isValidPhone(phone)) {

                        val intent = Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:$phone")
                        }

                        context.startActivity(intent)

                    } else {
                        isPhoneError = true
                        Toast
                            .makeText(
                                context,
                                "Введите корректный номер телефона",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                }
            ) {
                Text(stringResource(R.string.btn_call))
            }
        }
    }
}