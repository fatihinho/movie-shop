package com.fcinar.movieshop.dto

data class DirectorDto(
    val id: Long,
    val name: String,
    val surname: String,
    val movies: List<MovieDto>?
)
