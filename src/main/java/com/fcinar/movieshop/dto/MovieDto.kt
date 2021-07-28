package com.fcinar.movieshop.dto

data class MovieDto(
    val id: Long?,
    val name: String,
    val rank: Double,
    val director: DirectorDto
)
