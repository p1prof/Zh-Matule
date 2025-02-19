package com.example.zh_matuale.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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


data class Product(
    val id: Int
)


@Composable
fun PopularScreen(navHostController: NavHostController) {

    val products = List(50) { index ->
        Product(id = index + 1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9)),
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
                    contentDescription = "Heart Icon",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Text(
                text = "Популярное",
                modifier = Modifier.padding(vertical = 12.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )

            IconButton(
                onClick = {  }
            ) {
                Image(
                    painter = painterResource(R.drawable.heart_ic),
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
                CardItem(product)
            }
        }
    }
}


@Composable
fun CardItem(product: Product) {
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
                                if (isFavorite) R.drawable.hearted
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




@Preview(showBackground = true)
@Composable
fun PrevPopularScreen() {
    ZhMatualeTheme {
        PopularScreen(navHostController = rememberNavController())
    }
}