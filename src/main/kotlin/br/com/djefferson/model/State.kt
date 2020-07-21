package br.com.djefferson.model

import br.com.djefferson.model.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "state")
data class State(

        @Column(name = "name", nullable = false, length = 255)
        val name: String = ""

) : BaseEntity<Long>()