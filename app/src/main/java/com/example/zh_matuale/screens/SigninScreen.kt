package com.example.zh_matuale.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.navigation.NavRoute
import com.example.zh_matuale.ui.theme.ZhMatualeTheme
import com.example.zhdapp.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SigninScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("xyz@gmail.com") }
    var name by remember { mutableStateOf("Andrew") }
    var password by remember { mutableStateOf("xyz123!!!") }
    var isEmailValid by remember { mutableStateOf(true) }
    var isPasswordValid by remember { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    text = "Регистрация",
                    textAlign = TextAlign.Center,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.newpeninimmt))
                )

                Text(
                    text = "Заполните Свои Данные Или\nПродолжите Через Социальные Медиа",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding()
                        .fillMaxWidth(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.newpeninimmt)),
                    color = Color(0xFF707B81)
                )

                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column {
                        Text(
                            text = "Имя",
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.LightGray,
                                unfocusedContainerColor = Color.LightGray,
                                focusedIndicatorColor = Color.LightGray,
                                unfocusedIndicatorColor = Color.LightGray
                            )

                        )

                    }

                    Column {
                        Text(
                            text = "Email",
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            modifier = Modifier.fillMaxWidth()
                        )

                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email = it
                                isEmailValid = isValidEmail(it)
                            },
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.LightGray,
                                unfocusedContainerColor = Color.LightGray,
                                focusedIndicatorColor = Color.LightGray,
                                unfocusedIndicatorColor = Color.LightGray
                            ),
                            isError = !isEmailValid
                        )
                        if (!isEmailValid) {
                            Text(
                                text = "Некорректный email",
                                color = Color.Red,
                                fontSize = 12.sp,
                                modifier = Modifier.align(Alignment.Start)
                            )
                        }
                    }

                    PasswordTextField(password) { newPassword ->
                        password = newPassword
                        isPasswordValid = newPassword.isNotEmpty()
                    }

                    if (!isPasswordValid) {
                        Text(
                            text = "Пароль не может быть пустым",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }

                    Row(

                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Image(painter = painterResource(R.drawable.shield), contentDescription = "")
                        }

                        Text(
                            "Даю согласие на обработку\nперсональных данных",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            textDecoration = null
                        )
                    }

                    Button(
                        onClick = {
                            if (isEmailValid && isPasswordValid && email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()) {
                                navController.navigate(NavRoute.Log.route)
                            } else {
                                isEmailValid = isValidEmail(email)
                                isPasswordValid = password.isNotEmpty()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp)
                            .height(50.dp)
                            .align(Alignment.CenterHorizontally),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF48B2E7)
                        )
                    ) {
                        Text("Зарегистрироваться")
                    }
                }
            }

            Text(
                text = "Есть аккаунт? Войти",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .clickable { navController.navigate(NavRoute.Log.route) }
                    .padding(bottom = 12.dp),
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevSignScreen() {
    ZhMatualeTheme {
        SigninScreen(navController = rememberNavController())
    }
}
