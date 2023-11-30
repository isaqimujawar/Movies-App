package com.maddy.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.maddy.movieapp.model.Movie
import com.maddy.movieapp.model.getMovies

@Preview(name = "movie-row")
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}) {
    val clickedState = remember { mutableStateOf(false) }
    var enabled by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .clickable {
                onItemClick(movie.id)
                clickedState.value = !clickedState.value
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = CircleShape,
                shadowElevation = 4.dp,
                color = MaterialTheme.colorScheme.secondaryContainer

            ) {
                //Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image")
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.poster)
                        .crossfade(true)
                        .build(),      // if build() is not called on Builder() then causes a crash.
                    contentDescription = "Movie Poster",
                    modifier = Modifier.clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.padding(all = 4.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Release: ${movie.year}",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "Genre: ${movie.genre}",
                    style = MaterialTheme.typography.titleSmall
                )
                AnimatedVisibility(visible = enabled) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 12.sp
                                    )
                                ) {
                                    append("Plot: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                ) {
                                    append(movie.plot)
                                }
                            },
                            modifier = Modifier.padding(4.dp)
                        )
                        Divider(modifier = Modifier.padding(2.dp))
                        Text(
                            text = "Director: ${movie.director}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Rating: ${movie.rating}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Icon(
                    imageVector = if (enabled) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 24.dp)
                        .align(Alignment.CenterHorizontally)
                        .clickable { enabled = !enabled },
                    tint = Color.DarkGray
                )
            }
        }
    }
}