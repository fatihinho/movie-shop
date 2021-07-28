package com.fcinar.movieshop.model

import javax.persistence.*

@Entity
data class Director(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val surname: String,

    @OneToMany(mappedBy = "director", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val movies: Set<Movie>?
) {
    constructor(name: String, surname: String) : this(
        id = null,
        name = name,
        surname = surname,
        movies = HashSet()
    )
}
