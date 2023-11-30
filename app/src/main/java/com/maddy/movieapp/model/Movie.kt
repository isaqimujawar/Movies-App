package com.maddy.movieapp.model

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String
)

// We will create function to mock the Movie Database. Because we're getting our Movie Data locally,
fun getMovies(): List<Movie> =
    listOf(
        Movie(
            id = "t1",
            title = "Avatar",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana",
            plot = "Blue colored cartoons jumping around in shorts with a dragon.",
            poster = "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            images = listOf(
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            ),
            rating = "7.9"
        ),
        Movie(
            id = "t2",
            title = "The Wolf of Wall Street",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana",
            plot = "Blue colored cartoons jumping around in shorts with a dragon.",
            poster = "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            images = listOf(
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            ),
            rating = "7.9"
        ),
        Movie(
            id = "t3",
            title = "Harry Potter",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana",
            plot = "Blue colored cartoons jumping around in shorts with a dragon.",
            poster = "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            images = listOf(
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            ),
            rating = "7.9"
        ),
        Movie(
            id = "t4",
            title = "Spider-man",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana",
            plot = "Blue colored cartoons jumping around in shorts with a dragon.",
            poster = "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            images = listOf(
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            ),
            rating = "7.9"
        ),
        Movie(
            id = "t5",
            title = "The Great Gatsby",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana",
            plot = "Blue colored cartoons jumping around in shorts with a dragon.",
            poster = "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            images = listOf(
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            ),
            rating = "7.9"
        ),
        Movie(
            id = "t6",
            title = "Godfather",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana",
            plot = "Blue colored cartoons jumping around in shorts with a dragon.",
            poster = "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            images = listOf(
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
                "https://picfiles.alphacoders.com/461/thumb-461191.jpg",
            ),
            rating = "7.9"
        ),
    )

/*val movieList: List<String> = listOf(
    "Avatar",
    "The Wolf of Wall Street",
    "Harry Potter",
    "Spider-man",
    "Batman",
    "The Great Gatsby",
    "Lion King",
    "Godfather",
)*/
