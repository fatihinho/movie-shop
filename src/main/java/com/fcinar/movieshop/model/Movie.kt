package com.fcinar.movieshop.model

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.*

@Entity
data class Movie(
    @Id
    val id: UUID,
    val name: String,
    val rank: Double,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "director_id", nullable = false)
    val director: Director,
) {
    constructor(name: String, rank: Double, director: Director) : this(
        id = UUID.randomUUID(),
        name = name,
        rank = rank,
        director = director
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Movie

        return id == other.id
    }

    override fun hashCode(): Int = 693411677

    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , rank = $rank )"
    }
}
