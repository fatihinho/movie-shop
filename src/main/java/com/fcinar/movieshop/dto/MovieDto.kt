package com.fcinar.movieshop.dto

import com.fcinar.movieshop.model.Director
import java.util.*

data class MovieDto(
    val id: UUID,
    val name: String,
    val rank: Double,
    val director: Director
)
