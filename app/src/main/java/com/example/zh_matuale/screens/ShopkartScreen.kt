package com.example.zh_matuale.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.navigation.NavRoute
import com.example.zh_matuale.ui.theme.ZhMatualeTheme
import com.example.zhdapp.R
import kotlinx.coroutines.launch
import kotlin.math.abs

@Composable
fun ShopkartScreen(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffF7F7F9))
    ) {

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
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
                    text = "Корзина",
                    modifier = Modifier.padding(vertical = 12.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )

                IconButton(
                    onClick = { navHostController.navigate(NavRoute.Home.route) }
                ) {

                }
            }

            Text(
                text = "3 товара",
                modifier = Modifier.padding(vertical = 8.dp)
            )

            SwipeBox()
            SwipeBox()
            SwipeBox()

        }

        Spacer(Modifier.height(60.dp))

        Column(
            modifier = Modifier.padding(),
            verticalArrangement = Arrangement.Bottom
        ) {
            CartBottomBar()
        }
    }
}


@Composable
fun Inforow3(leftbar: Int, rightbar: Int) {
    var count by remember { mutableStateOf(1) }
    count = count.coerceAtLeast(1)


    val leftOffset: Dp by animateDpAsState(
        if (leftbar > 0) 0.dp else -100.dp,
        animationSpec = tween(300)
    )
    val rightOffset: Dp by animateDpAsState(
        if (rightbar > 0) 0.dp else 100.dp,
        animationSpec = tween(300)
    )

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Левая карточка
        if (leftbar > 0) {
            Card(
                modifier = Modifier
                    .width(65.dp)
                    .height(150.dp)
                    .padding(vertical = 16.dp)
                    .offset(x = leftOffset),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(0.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF48ABE7))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = { count++ }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.pl),
                            contentDescription = ""
                        )
                    }
                    Text(
                        text = count.toString(),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(4.dp)
                    )
                    IconButton(
                        onClick = { count-- }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.mn),
                            contentDescription = ""
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
        }

        // Центральная карточка
        Card(
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterVertically)
                        .background(Color(0xFFF7F7F9), shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.nike),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        alignment = Alignment.Center
                    )
                }
                Spacer(modifier = Modifier.width(28.dp))
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Nike Max Pro"
                    )
                    Text(
                        text = "₽754.95"
                    )
                }
            }
        }

        // Правая карточка
        if (rightbar > 0) {
            Spacer(modifier = Modifier.width(16.dp))
            Card(
                modifier = Modifier
                    .width(65.dp)
                    .height(150.dp)
                    .padding(vertical = 16.dp)
                    .offset(x = rightOffset),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(0.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF87265))
            ) {
                IconButton(
                    onClick = {},
                    Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(R.drawable.trash),
                        contentDescription = "",
                        Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SwipeBox() {
    val coroutineScope = rememberCoroutineScope()
    var lef by remember { mutableStateOf(0) }
    var rig by remember { mutableStateOf(0) }

    val minSwipeDistance = 50f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .pointerInput(Unit) {
                var accumulatedDrag = 0f
                detectHorizontalDragGestures { _, dragAmount ->
                    accumulatedDrag += dragAmount
                    if (abs(accumulatedDrag) > minSwipeDistance) {
                        when {
                            accumulatedDrag > 0 -> {
                                // Свайп вправо
                                coroutineScope.launch {
                                    if (rig == 1) {
                                        lef = 0
                                        rig = 0
                                    } else if (lef == 0 && rig == 0) {
                                        lef = 1
                                        rig = 0
                                    }
                                }
                            }

                            accumulatedDrag < 0 -> {
                                // Свайп влево
                                coroutineScope.launch {
                                    if (lef == 1) {
                                        lef = 0
                                        rig = 0
                                    } else if (lef == 0 && rig == 0) {
                                        lef = 0
                                        rig = 1
                                    }
                                }
                            }
                        }
                        accumulatedDrag = 0f
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {

        Inforow3(leftbar = lef, rightbar = rig)
    }
}


@Composable
fun CartBottomBar() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Сумма",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
                Text(
                    text = "₽753.95",
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Доставка",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
                Text(
                    text = "₽60.20",
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))


            DashedLine(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            )

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Итого",
                    fontSize = 18.sp
                )
                Text(
                    text = "₽814.15",
                    fontSize = 14.sp,
                    color = Color(0xFF48B2E7)
                )
            }

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF48B2E7)
                )
            ) {
                Text("Оформить Заказ")
            }
        }
    }
}

@Composable
fun DashedLine(
    modifier: Modifier = Modifier,
    color: Color = Color.LightGray,
    strokeWidth: Float = with(LocalDensity.current) { 3.dp.toPx() },
    segmentLength: Float = 30f,
    gapLength: Float = 30f
) {
    Canvas(modifier = modifier) {
        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(segmentLength, gapLength), 0f)
        drawLine(
            color = color,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = strokeWidth,
            pathEffect = pathEffect
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PrevShopkartScreen() {
    ZhMatualeTheme {
        ShopkartScreen(rememberNavController())
    }
}