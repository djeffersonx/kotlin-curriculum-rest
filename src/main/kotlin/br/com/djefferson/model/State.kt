package br.com.djefferson.model

import br.com.djefferson.model.generics.AbstractJpaEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "state")
data class State(

        @Column(name = "name", nullable = false, length = 255)
        val name: String

) : AbstractJpaEntity<Long>()