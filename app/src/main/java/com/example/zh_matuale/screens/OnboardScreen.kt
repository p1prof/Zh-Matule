package com.example.zh_matuale.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.ui.theme.ZhMatualeTheme
import com.example.zhdapp.R

@Composable
fun OnboardScreen(
    navController: NavHostController,
    onFinish: () -> Unit
) {
    // Страницы онбординга
    val onboardingPages = listOf(
        OnboardingPage(
            title = "Добро\nпожаловать",
            description = "",
            imageRes = R.drawable.shoe_1
        ),
        OnboardingPage(
            title = "Начнем\nпутешествие",
            description = "Умная, великолепная и модная\nколлекция Изучите сейчас",
            imageRes = R.drawable.shoe_2
        ),
        OnboardingPage(
            title = "У вас есть сила,\nчтобы...",
            description = "В вашей комнате много красивых и привлекательных растений",
            imageRes = R.drawable.shoe_3
        )
    )

    var currentPage by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF48B2E7),
                        Color(0xFF2B6B8B)
                    )
                )
            )
            .padding(0.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            OnboardingContent(page = onboardingPages[currentPage], pagenm = currentPage)
        }


        OnboardingIndicator(
            totalPages = onboardingPages.size,
            currentPage = currentPage
        )


        Button(
            onClick = {
                if (currentPage < onboardingPages.size - 1) {
                    currentPage++
                } else {
                    onFinish() // Вызов callback после последнего экрана
                }
            },
            modifier = Modifier
                .width(350.dp)
                .padding(vertical = 32.dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(13.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text(if (currentPage == 0) "Начать" else "Далее",
                color = Color.Black)
        }
    }
}

@Composable
fun OnboardingContent(page: OnboardingPage, pagenm: Int) {

    if (pagenm == 0) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = page.title,
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Light,
                    minLines = 2,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        lineHeight = 35.sp
                    )
                )
            }

            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                alignment = Alignment.Center
            )
            Text(
                text = page.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

    }

    else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()

        ) {
            Image(
                painter = painterResource(id = page.imageRes),
                alignment = Alignment.TopCenter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )
            Column(
                modifier = Modifier
                    .padding()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = page.title,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Light,
                    minLines = 2,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        lineHeight = 35.sp
                    )
                )

                Text(
                    text = page.description,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

}

@Composable
fun OnboardingIndicator(totalPages: Int, currentPage: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        for (page in 0 until totalPages) {
            Box(
                modifier = Modifier
                    .size(
                        width = if (page == currentPage) 55.dp else 38.dp,
                        height = 8.dp
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        if (page == currentPage) Color.White else Color.Gray
                    )
                    .clickable { }
            )

            if (page < totalPages - 1) {
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}



data class OnboardingPage(
    val title: String,
    val description: String,
    val imageRes: Int
)

@Preview(showBackground = true)
@Composable
fun PrevOnboardScreen() {
    ZhMatualeTheme {
        OnboardScreen(
            navController = rememberNavController(),
            onFinish = {}
        )
    }
}