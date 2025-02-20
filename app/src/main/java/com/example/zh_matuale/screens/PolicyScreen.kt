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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.zh_matuale.navigation.NavRoute
import com.example.zh_matuale.ui.theme.ZhMatualeTheme
import com.example.zhdapp.R

@Composable
fun PolicyScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F9))
            .padding(16.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { navController.navigate(NavRoute.SigninScreen) }) {
                Image(painter = painterResource(R.drawable.arrowback), contentDescription = "")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Политика Конфиденциальности", modifier = Modifier.align(Alignment.CenterVertically))
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.size(35.dp)){}
        }

        Text(text = "политикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикап" +
                "олитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикапол" +
                "итикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполи" +
                "тикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикап" +
                "олитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикаполитикапо" +
                "литикаполитикаполитикаполитикаполитикаполитикаполитикаполитикам")
    }
}

@Composable
@Preview(showBackground = true)
fun PrevLokicyScreen() {
    ZhMatualeTheme {
        PolicyScreen(rememberNavController())
    }
}