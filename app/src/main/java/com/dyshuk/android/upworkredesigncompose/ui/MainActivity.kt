package com.dyshuk.android.upworkredesigncompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dyshuk.android.upworkredesigncompose.ui.theme.UpworkRedesignComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UpworkRedesignComposeTheme() {
                UpworkRedesignApp()
            }
        }
    }
}