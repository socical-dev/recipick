package com.socical.recipick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.socical.recipick.ui.theme.RecipickTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RecipickTheme { //앱 전체 테마 적용 설정
                Surface(color = MaterialTheme.colorScheme.background) {
                }
            }
        }
    }
}