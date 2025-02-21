package com.example.zh_matuale.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.navigation.NavRoute
import com.example.zh_matuale.ui.theme.ZhMatualeTheme
import com.example.zhdapp.R

@Composable
fun ProfileScreen(navController: NavHostController) {

    val edit by remember { mutableStateOf(false) }


    if (!edit) { ProfScreenNoEdit() }
    else { ProfEdit() }


    CustomBottomBar3(navController = rememberNavController())

}


@Composable
fun ProfScreenNoEdit() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(R.drawable.hamburger), contentDescription = "")
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(text = "Профиль", fontSize = 19.sp, modifier = Modifier)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(R.drawable.redact), contentDescription = "")
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(R.drawable.prfp), contentDescription = "", modifier = Modifier.size(110.dp))
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = "Emmanuel Oyiboke",
                    fontSize = 22.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(painter = painterResource(R.drawable.barcode), contentDescription = "")
            }

            Column(Modifier.padding(vertical = 8.dp)){
                Text(text = "Имя")
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, shape = RoundedCornerShape(15.dp))
                        .padding(12.dp),
                ) {
                    Text(text = "Emmanuel")
                }
            }

            Column(Modifier.padding(vertical = 8.dp)){
                Text(text = "Фамилия")
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, shape = RoundedCornerShape(15.dp))
                        .padding(12.dp),
                ) {
                    Text(text = "Oyiboke")
                }
            }

            Column(Modifier.padding(vertical = 8.dp)){
                Text(text = "Адрес")
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, shape = RoundedCornerShape(15.dp))
                        .padding(12.dp),
                ) {
                    Text(text = "Nigeria")
                }
            }

            Column(Modifier.padding(vertical = 8.dp)){
                Text(text = "Телефон")
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray, shape = RoundedCornerShape(15.dp))
                        .padding(12.dp),
                ) {
                    Text(text = "+7 811-732-5298")
                }
            }
        }

    }
}


@Composable
fun ProfEdit() {
    var name by remember { mutableStateOf("Emmanuel") }
    var  sername by remember { mutableStateOf("Oyiboke") }
    var adress by remember { mutableStateOf("Nigeria") }
    var number by remember { mutableStateOf("+7 811-732-5298") }
    var isEmailValid by remember { mutableStateOf(true) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F9))
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Button(
                    onClick = { TODO() },
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(vertical = 16.dp)
                        .height(40.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF48B2E7)
                    )
                ) {
                    Text("Сохранить")
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(R.drawable.prfp), contentDescription = "", modifier = Modifier.size(80.dp))
                    Text(
                        modifier = Modifier.padding(vertical = 8.dp),
                        text = "Emmanuel Oyiboke",
                        fontSize = 20.sp
                    )

                    Row {
                        Text(text = "изменить фото профиля", modifier = Modifier, fontSize = 12.sp, color = Color(0xFF48B2E7))
                    }
                }



                Column {
                    Text(
                        text = "Имя",
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = name,
                        onValueChange = {
                            name = it
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
                    if (name.isEmpty()) {
                        Text(
                            text = "поле не может быть пустым",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }

                Column {
                    Text(
                        text = "Фамилия",
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = sername,
                        onValueChange = {
                            sername = it
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

                    )
                    if (sername.isEmpty()) {
                        Text(
                            text = "поле не может быть пустым",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }

                Column {
                    Text(
                        text = "Адресс",
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = adress,
                        onValueChange = {
                            adress = it
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

                    )
                    if (adress.isEmpty()) {
                        Text(
                            text = "поле не может быть пустым",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }

                Column {
                    Text(
                        text = "Телефон",
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = number,
                        onValueChange = {
                            number = it
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

                    )
                    if (number.isEmpty()) {
                        Text(
                            text = "поле не может быть пустым",
                            color = Color.Red,
                            fontSize = 12.sp,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }
            }

        }
    }



@Composable
fun CustomBottomBar3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color(0xFFF7F7F9)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.bottom_bar),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )


            Box(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.Center)
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(100.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.main_ic),
                        contentDescription = "Main",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Bottom
            ) {
                IconButton(onClick = { navController.navigate(NavRoute.Home.route) }) {
                    Image(
                        painter = painterResource(R.drawable.home1),
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(Modifier.width(16.dp))

                IconButton(onClick = {  } ) {
                    Image(
                        painter = painterResource(R.drawable.fav),
                        contentDescription = "Favorites",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(R.drawable.notification),
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(R.drawable.pfp),
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun PrevProfileScreen() {
    ZhMatualeTheme {
        ProfileScreen(rememberNavController())
    }
}