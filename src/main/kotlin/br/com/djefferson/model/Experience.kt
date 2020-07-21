package br.com.djefferson.model

import br.com.djefferson.model.base.BaseEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "experience")
data class Experience(

        @Column(name = "role", nullable = false, length = 255)
        val role: String = "",

        @Temporal(TemporalType.DATE)
        @Column(name = "datestart", nullable = false, length = 255)
        val dateStart: Date? = null,

        @Temporal(TemporalType.DATE)
        @Column(name = "dateend", nullable = false, length = 255)
        val dateEnd: Date? = null

) : BaseEntity<Long>()