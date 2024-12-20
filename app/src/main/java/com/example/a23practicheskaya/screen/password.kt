package com.example.a23practicheskaya.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pr23_smartlab_boboev_e_.R
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.a23practicheskaya.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PasswordScreen(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var pressedKey by remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextButton(
            onClick = {
                navController.navigate(Screen.PatientRecord.route)
            }
        ) {
            Text(
                text = "Пропустить",
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(top = 84.dp, end = 20.dp, bottom = 40.dp)
                    .fillMaxWidth(),
                color = colorResource(R.color.purple_500)
            )
        }

        Text(
            text = "Создайте пароль",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            color = colorResource(R.color.black),
            fontSize = 24.sp
        )
        Text(
            text = "Для защиты ваших персональных данных",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 56.dp)
                .fillMaxWidth(),
            color = colorResource(R.color.button),
            fontSize = 15.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(2.dp)
                        .background(
                            color = if (index < password.length) colorResource(R.color.blu1) else Color.White,
                            shape = CircleShape
                        )
                        .border(
                            width = 1.dp,
                            colorResource(R.color.blu1),
                            RoundedCornerShape(18.dp)
                        )
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val keys = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "⌫")
            keys.chunked(3).forEach { rowKeys ->
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowKeys.forEach { key ->
                        val isPressed = key == pressedKey
                        Button(
                            onClick = {
                                pressedKey = key
                                coroutineScope.launch {
                                    delay(400)
                                    pressedKey = ""
                                }
                                when (key) {
                                    "⌫" -> {
                                        if (password.isNotEmpty()) {
                                            password = password.dropLast(1)
                                        }
                                    }
                                    else -> {
                                        if (password.length < 4) {
                                            password += key
                                        } else if (password.length == 4) {
                                            navController.navigate(Screen.PatientRecord.route)
                                        }
                                    }
                                }
                            },
                            modifier = Modifier
                                .size(72.dp)
                                .background(
                                    if (isPressed) colorResource(R.color.blu1) else colorResource(R.color.gray2),
                                    CircleShape
                                ),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = if (key == "⌫") Color.Black else if (isPressed) Color.White else Color.Black,
                                containerColor = if (key == "⌫") Color.White else if (isPressed) colorResource(R.color.blu1) else colorResource(R.color.gray2)
                            ),
                            shape = CircleShape
                        ) {
                            Text(
                                text = key,
                                fontSize = 24.sp
                            )
                        }
                    }
                }
            }
        }
    }
}