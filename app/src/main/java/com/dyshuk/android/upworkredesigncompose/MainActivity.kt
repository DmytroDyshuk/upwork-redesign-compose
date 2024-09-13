package com.dyshuk.android.upworkredesigncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            UpworkRedesignComposeTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Hello World!", modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}