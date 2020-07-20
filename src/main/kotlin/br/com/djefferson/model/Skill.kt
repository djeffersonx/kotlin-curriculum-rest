package br.com.djefferson.model

import br.com.djefferson.model.generics.AbstractJpaEntity
import javax.persistence.*

@Entity
@Table(name = "skill")
data class Skill(

        @Column(name = "name", nullable = false, length = 255)
        val name: String,

        @Column(name = "level", nullable = false, length = 255)
        val level: Integer

) : AbstractJpaEntity<Long>()