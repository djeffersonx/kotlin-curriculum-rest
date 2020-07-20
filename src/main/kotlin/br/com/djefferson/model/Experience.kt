package br.com.djefferson.model

import br.com.djefferson.model.generics.AbstractJpaEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "experience")
data class Experience(

        @Column(name = "role", nullable = false, length = 255)
        val role: String,

        @Temporal(TemporalType.DATE)
        @Column(name = "datestart", nullable = false, length = 255)
        val dateStart: Date,

        @Temporal(TemporalType.DATE)
        @Column(name = "dateend", nullable = false, length = 255)
        val dateEnd: Date

) : AbstractJpaEntity<Long>()