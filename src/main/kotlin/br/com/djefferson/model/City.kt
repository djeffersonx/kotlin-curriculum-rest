package br.com.djefferson.model

import br.com.djefferson.model.generics.AbstractJpaEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "city")
data class City(

        @Column(name = "name", nullable = false, length = 255)
        val name: String,

        @ManyToOne
        @JoinColumn(name = "idstate", nullable = false, foreignKey = ForeignKey(name = "fkcityidstate"))
        val state: State

) : AbstractJpaEntity<Long>()