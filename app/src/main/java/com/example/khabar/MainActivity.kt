package com.example.khabar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.khabar.domain.usecases.AppEntryUseCases
import com.example.khabar.presentation.onboarding.OnboardingScreen
import com.example.khabar.ui.theme.KhabarTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        checkForOnboarding()
        setContent {
            KhabarTheme {
                Box(
                   modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                ){
                    OnboardingScreen()
                }
            }
        }
    }

    private fun checkForOnboarding() {
        lifecycleScope.launch {
            val readAppEntryFlow = appEntryUseCases.readAppEntry.invoke()
            readAppEntryFlow.collect{ status ->
                println("___________$status")
            }
        }
    }
}