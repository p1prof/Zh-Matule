package com.example.zh_matuale.screens


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.zh_matuale.ui.theme.ZhMatualeTheme

@Composable
fun LogScreen() {
    Text(text = "TEXT")
}

@Preview(showBackground = true)
@Composable
fun PrevLogScreen() {
    ZhMatualeTheme {
        LogScreen()
    }
}