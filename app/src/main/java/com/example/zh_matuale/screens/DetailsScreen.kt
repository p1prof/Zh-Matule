package com.example.zh_matuale.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
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
fun DetailsScreen(navController: NavHostController) {

    var more by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffF7F7F9))
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { navController.navigate(NavRoute.Home.route) }
            ) {
                Image(
                    painter = painterResource(R.drawable.arrowback),
                    contentDescription = "Heart Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Text(
                text = "Sneaker Shop",
                modifier = Modifier.padding(vertical = 12.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )

            IconButton(
                onClick = {  }
            ) {
                Image(
                    painter = painterResource(R.drawable.cartcirc),
                    contentDescription = "Heart Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Column(
            Modifier.padding( vertical = 32.dp)
        ) {
            Text(
                modifier = Modifier.padding(),
                text = "Nike Air Max 270\nEssential",
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Men’s Shoes",
                fontSize = 20.sp,
                color = Color(0xff6A6A6A)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "₽179.39",
                fontSize = 22.sp,
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(200.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.bigshoe),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(300.dp)
            )

            Image(
                painter = painterResource(R.drawable.ring),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()

            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MiniCard(shoenm = 1, ind = 0)
            MiniCard(shoenm = 2, ind = 0)
            MiniCard(shoenm = 3, ind = 0)
            MiniCard(shoenm = 4, ind = 1)
            MiniCard(shoenm = 5, ind = 0)
        }

        Column(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(
                if (more % 2 != 0) {"Вставка Max Air 270 обеспечивает непревзойденный комфорт в течение всего дня. Изящный дизайн ........"}
                else {"Вставка Max Air 270 обеспечивает непревзойденный комфорт в течение всего дня. Изящный дизайн способствует проверке логики программы на нажатие кнопочки подробнее, можете проверить , как хорошо работает такая логика зящный дизайн способствует проверке логики программы на нажатие кнопочки подробнее, можете проверить!!!"},
                fontSize = 16.sp,
                color = Color(0xff6A6A6A),
                fontWeight = FontWeight.Normal
            )

            Text(
                text = if ( more % 2 != 0 ) {"Подробнее"}
                    else {"Скрыть"},
                modifier = Modifier.align(Alignment.End).clickable { more++ },
                color = Color(0xff48B2E7)
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(60.dp),
            ){
                Image(
                    painter = painterResource(R.drawable.greyheart),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "" )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navController.navigate(NavRoute.Shopkart.route) },
                modifier = Modifier
                    .width(280.dp)
                    .padding(vertical = 32.dp)
                    .height(70.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF48B2E7))
            ) {
                Row(

                ) {
                    Image(painter = painterResource(R.drawable.bag2), contentDescription = "", alignment = Alignment.Center)
                    Spacer(modifier = Modifier.width(48.dp))
                    Text("В Корзину", fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterVertically))
                    Spacer(modifier = Modifier.weight(1f))
                    Box(Modifier.size(50.dp)) {  }
                }

            }

        }

    }
}


@Composable
fun MiniCard(shoenm: Int, ind: Int) {

    var resr = shoenm
    var resval = R.drawable.sh3

    if (resr == 1 ) resval = R.drawable.sh7
    if (resr == 2 ) resval = R.drawable.sh2
    if (resr == 3 ) resval = R.drawable.sh7
    if (resr == 4 ) resval = R.drawable.sh2
    if (resr == 5 ) resval = R.drawable.nike

    Card(
        modifier = Modifier
            .size(65.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xffFFFFFF))
        ) {
            Image(
                painter = painterResource(resval),
                contentDescription = "",
                modifier = Modifier.clickable {  }
            )
        }

    }
}

@Composable
@Preview
fun PrevDetailsScreen() {
    ZhMatualeTheme {
        DetailsScreen(navController = rememberNavController())
    }
}