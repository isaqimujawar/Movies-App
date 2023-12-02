package com.maddy.movieapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.maddy.movieapp.data.MovieLocalDataSource
import com.maddy.movieapp.model.Movie
import com.maddy.movieapp.navigation.MovieScreens
import com.maddy.movieapp.ui.theme.MovieAppTheme
import com.maddy.movieapp.widgets.MovieRow

val movieList: List<Movie> = MovieLocalDataSource.getMovies()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    MovieAppTheme {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Movies") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }, bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    text = "Bottom App Bar",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }, floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Button")

            }
        }

        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding), verticalArrangement = Arrangement.Top
            ) {
                MainContent(
                    navController = navController,
                    movieList = movieList
                )
            }
        }
    }
}

@Composable
fun MainContent(navController: NavController, movieList: List<Movie>) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movieId ->
                    // Remember to add forward slash "/" to your route, because this is like a WebLink.
                    // if "/" is not included in link then it will throw a IllegalArgumentException,
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/" + movieId)
                }
            }
        }
    }
}

