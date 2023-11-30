package com.maddy.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.maddy.movieapp.navigation.MovieNavigation
import com.maddy.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable () -> Unit) {
    content()
}

@Preview(name = "my app", showSystemUi = true, showBackground = true)
@Composable
fun MyAppPreview() {
    MovieAppTheme {
        MyApp {
            MovieNavigation()
        }
    }
}