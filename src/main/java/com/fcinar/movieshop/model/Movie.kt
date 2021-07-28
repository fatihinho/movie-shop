package com.fcinar.movieshop.model

import javax.persistence.*

@Entity
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val rank: Double,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", nullable = true)
    val director: Director?,
) {
    constructor(name: String, rank: Double) : this(
        id = null,
        name = name,
        rank = rank,
        director = null
    )
}
