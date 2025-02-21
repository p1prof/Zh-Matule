package com.example.zh_matuale.screens

import android.content.ClipData.Item
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
fun NotionScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { navController.navigate(NavRoute.SigninScreen) }) {
                Image(painter = painterResource(R.drawable.hamburger), contentDescription = "")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Уведомления", modifier = Modifier.align(Alignment.CenterVertically), fontSize = 19.sp)
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.size(35.dp)){}
        }

        LazyColumn {
            item { note() }
            item { note() }
            item { note() }
            item { note() }
            item { note() }
            item { note() }
            item { note() }
            item { note() }
        }
    }

    CustomBottomBar4(navController = rememberNavController())

}


@Composable
fun CustomBottomBar4(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
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
                        painter = painterResource(R.drawable.not2),
                        contentDescription = "Notifications",
                        modifier = Modifier.size(24.dp)
                    )
                }
                IconButton(onClick = { navController.navigate(NavRoute.ProfileScreen.route) }) {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun note() {

    Column(
        modifier = Modifier.padding(vertical = 24.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Заголовок",
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = "Lorem ipsum dolor sit amet consectetur." +
                "Venenatis pulvinar lobortis risus consectetur morbi egestas id in bibendum." +
                "Volutpat nulla urna sit sed diam nulla.",
            fontSize = 15.sp
        )

        Text(
            text = "27.01.2024, 15:42",
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            color = Color(0xff707B81)
        )

    }

}

@Composable
@Preview(showBackground = true)
fun PrevNotionScreen() {
    ZhMatualeTheme {
        NotionScreen(rememberNavController())
    }
}