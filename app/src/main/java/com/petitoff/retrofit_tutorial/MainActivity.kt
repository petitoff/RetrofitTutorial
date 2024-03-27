package com.petitoff.retrofit_tutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.petitoff.retrofit_tutorial.routing.viewmodels.RouteViewModel
import com.petitoff.retrofit_tutorial.ui.theme.RetrofitTutorialTheme

class MainActivity : ComponentActivity() {
    private val routeViewModel: RouteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    routeViewModel.route.observe(this@MainActivity) { route ->
                        // Update your UI here with the new route
                        Log.i("MainActivity", "Route: ${route.route}")
                    }
                }
            }
        }
    }
}

