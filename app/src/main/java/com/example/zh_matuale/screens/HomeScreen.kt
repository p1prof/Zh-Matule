package com.example.zh_matuale.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.navigation.NavRoute
import com.example.zh_matuale.ui.theme.ZhMatualeTheme
import com.example.zhdapp.R


@Composable
fun HomeScreen(navHostController: NavHostController) {

    Column(

        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .background(Color(0xFFF7F7F9))
        ) {

            TopBar(navHostController)

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar()

            Spacer(modifier = Modifier.height(16.dp))

            CategoriesRow(navHostController)

            Spacer(modifier = Modifier.height(16.dp))

            SectionTitle("Популярное", navHostController)

            PopularItemsGrid()

            Spacer(modifier = Modifier.height(8.dp))

            SectionTitle("Акции", navHostController)
            PromotionsSection()
        }

        CustomBottomBar(navHostController)

    }
}

@Composable
fun TopBar(navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* TODO: Открыть меню */ }) {
            Image(painter = painterResource(R.drawable.hamburger), contentDescription = "")
        }
        Text(
            text = "Главная",
            fontSize = 35.sp,
            fontWeight = FontWeight.Light
        )
        IconButton(
            onClick = {navController.navigate(NavRoute.Shopkart.route) },
            modifier = Modifier.size(45.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.app_icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun SearchBar() {

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(14.dp))
                .background(Color.White, RoundedCornerShape(14.dp))
                .width(290.dp)
                .height(50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp), // Отступы внутри строки
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Search, contentDescription = "Поиск", tint = Color.Gray)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Поиск",
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Button(
            onClick = {  },
            modifier = Modifier
                .size(53.dp)
                .shadow(5.dp, RoundedCornerShape(56.dp))
                .padding(),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF48B2E7),
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.sliders),
                contentDescription = "Icon",
                modifier = Modifier
                    .fillMaxSize(0.5f),
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Composable
fun CategoriesRow(navController: NavHostController) {

    Text(
        text = "Категории",
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(horizontal = 16.dp)
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement =  Arrangement.SpaceEvenly
    ) {
        listOf("Все", "Outdoor", "Tennis").forEach { category ->
            Button(
                onClick = {  },
                modifier = Modifier
                    .padding(vertical = 0.dp)
                    .width(100.dp)
                    .height(46.dp)
                    .shadow(0.dp, RoundedCornerShape(14.dp))
                    .background(Color.White, RoundedCornerShape(14.dp)),
                shape = RoundedCornerShape(14.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = category,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}


@Composable
fun SectionTitle(title: String, navController: NavHostController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = "Все",
            color = Color(0xFF48B2E7),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .clickable { navController.navigate(NavRoute.Popular.route) }
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun PopularItemsGrid() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
            .height(210.dp)
    ) {
        CardItems()
        Spacer(modifier = Modifier.width(12.dp))
        CardItems2()
    }
}

@Composable
fun CardItems() {
    var heartstate by remember { mutableStateOf(1) }
    var cartstate by remember { mutableStateOf(1) }

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(190.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Top
            ) {

                Box(
                    modifier = Modifier
                        .size(35.dp),
                ) {
                    IconButton(
                        onClick = {heartstate++}
                    ) {
                        Image(
                            painter = painterResource(
                                if(heartstate % 2 == 0) {R.drawable.hearted;}
                                else {R.drawable.heart_ic}
                            ),
                            contentDescription = "Heart Icon",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painter = painterResource(R.drawable.nike),
                        contentDescription = "Sneaker",
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(50.dp)
                            .align(Alignment.TopCenter)
                    )
                }

                Text(
                    text = "BEST SELLER",
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 4.dp),
                    color = Color(0xFF48B2E7)
                )
                Text(
                    text = "Nike Pro Max",
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp,
                    modifier = Modifier.padding()
                )

                Text(
                    text = "₽752.00",
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }


            IconButton(
                onClick = { cartstate++ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .size(35.dp)
            ) {
                Image(
                    painter =
                    if(cartstate % 2 ==0) painterResource(R.drawable.cart_ic2)
                    else painterResource(R.drawable.plus),
                    contentDescription = "Plus Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Composable
fun CardItems2() {
    var heartstate by remember { mutableStateOf(1) }
    var cartstate by remember { mutableStateOf(1) }

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(190.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Top
            ) {

                Box(
                    modifier = Modifier
                        .size(35.dp),
                ) {
                    IconButton(
                        onClick = {heartstate++}
                    ) {
                        Image(
                            painter = painterResource(
                                if(heartstate % 2 == 0) {R.drawable.hearted;}
                                else {R.drawable.heart_ic}
                            ),
                            contentDescription = "Heart Icon",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painter = painterResource(R.drawable.nike),
                        contentDescription = "Sneaker",
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(50.dp)
                            .align(Alignment.TopCenter)
                    )
                }

                Text(
                    text = "BEST SELLER",
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 4.dp),
                    color = Color(0xFF48B2E7)
                )
                Text(
                    text = "Nike Pro Max",
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp,
                    modifier = Modifier.padding()
                )

                Text(
                    text = "₽752.00",
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }


            IconButton(
                onClick = { cartstate++ },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .size(35.dp)
            ) {
                Image(
                    painter =
                    if(cartstate % 2 ==0) painterResource(R.drawable.cart_ic)
                    else painterResource(R.drawable.plus),
                    contentDescription = "Plus Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}



@Composable
fun PromotionsSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
            .background(Color(0xFFF7F7F9))
            .height(95.dp),
        shape = RoundedCornerShape(24.dp),
    ) {

        Image(
            painter = painterResource(R.drawable.sales),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F9))
        )

    }
}



@Composable
fun CustomBottomBar(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
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
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(R.drawable.home2),
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(Modifier.width(16.dp))

                IconButton(onClick = { } ) {
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
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun PrevHomeScreen() {
    ZhMatualeTheme {
        HomeScreen(navHostController = rememberNavController())
    }
}