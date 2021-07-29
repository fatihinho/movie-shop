package com.fcinar.movieshop.model

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.*
import kotlin.collections.HashSet

@Entity
data class Director(
    @Id
    val id: UUID,
    val name: String,
    val surname: String,

    @OneToMany(mappedBy = "director", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val movies: Set<Movie>?
) {
    constructor(name: String, surname: String) : this(
        id = UUID.randomUUID(),
        name = name,
        surname = surname,
        movies = HashSet()
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Director

        return id == other.id
    }

    override fun hashCode(): Int = 1208779318

    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , surname = $surname )"
    }
}
