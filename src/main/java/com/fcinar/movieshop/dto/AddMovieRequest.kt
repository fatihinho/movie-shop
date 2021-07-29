package com.fcinar.movieshop.dto

import java.util.*

data class AddMovieRequest(
    val name: String,
    val rank: Double,
    val directorId: UUID
)
