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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.navigation.NavRoute
import com.example.zh_matuale.ui.theme.ZhMatualeTheme
import com.example.zhdapp.R


data class Product2(
    val id: Int
)


@Composable
fun FavoriteScreen(navHostController: NavHostController) {
    val products = List(50) { index ->
        Product2(id = index + 1)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F7F9))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { navHostController.navigate(NavRoute.Home.route) }
                ) {
                    Image(
                        painter = painterResource(R.drawable.arrowback),
                        contentDescription = "Back Icon",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    text = "Избранное",
                    modifier = Modifier.padding(vertical = 12.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
                IconButton(
                    onClick = { navHostController.navigate(NavRoute.Home.route) }
                ) {
                    Image(
                        painter = painterResource(R.drawable.hearted),
                        contentDescription = "Heart Icon",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(products) { product ->
                    CardItem2(product)
                }
            }
        }


        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            CustomBottomBar2()
        }
    }
}


@Composable
fun CardItem2(product: Product2) {
    var isFavorite by remember { mutableStateOf(false) }
    var inCart by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp)
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart) {
                    IconButton(onClick = { isFavorite = !isFavorite }) {
                        Image(
                            painter = painterResource(
                                if (!isFavorite) R.drawable.hearted
                                else R.drawable.heart_ic
                            ),
                            contentDescription = "Favorite Icon",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.nike),
                        contentDescription = "Sneaker Image",
                        modifier = Modifier.size(100.dp)
                    )
                }


                Text(
                    text = "BEST SELLER",
                    color = Color(0xFF48B2E7),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Nike Pro Max ${product.id}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "₽752.00",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }


            IconButton(
                onClick = { inCart = !inCart },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .size(32.dp)
            ) {
                Image(
                    painter = painterResource(
                        if (inCart) R.drawable.cart else R.drawable.plus
                    ),
                    contentDescription = "Add to Cart Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Composable
fun CustomBottomBar2(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFF7F7F9)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.bottom_bar),
            contentDescription = "Bottom Bar Background",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Image(
                    painter = painterResource(R.drawable.home1),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.blueheart),
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


        Box(
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-32).dp)
                .background(Color.White, shape = RoundedCornerShape(50))
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.main_ic),
                    contentDescription = "Main Button",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Preview
@Composable
fun PrevFavoriteScreen() {
    ZhMatualeTheme {
        FavoriteScreen(navHostController = rememberNavController())
    }
}