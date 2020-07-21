package br.com.djefferson.model

import br.com.djefferson.model.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "resource")
data class Resource(

        @Column(name = "name", nullable = false, length = 255)
        val name: String = "",

        @Temporal(TemporalType.DATE)
        @Column(name = "datebirth", nullable = false)
        val dateBirth: Date? = null,

        @ManyToOne
        @JoinColumn(name = "idcity", nullable = false, foreignKey = ForeignKey(name = "fkresourceidcity"))
        val city: City? = null,

        @JsonManagedReference
        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "resource_skill", joinColumns = [JoinColumn(name = "idresource")], inverseJoinColumns = [JoinColumn(name = "idskill")])
        val skills: Set<Skill> = setOf(),

        @JsonManagedReference
        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(name = "resource_experience", joinColumns = [JoinColumn(name = "idresource")], inverseJoinColumns = [JoinColumn(name = "idexperience")])
        val experiences: Set<Experience> = setOf()

) : BaseEntity<Long>()