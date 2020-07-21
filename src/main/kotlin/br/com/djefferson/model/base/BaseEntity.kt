package br.com.djefferson.model.base

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.util.ProxyUtils
import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity<T : Serializable> {

    @Id
    @GeneratedValue
    private var id: T? = null

    fun getId(): T? {
        return id
    }

    @JsonIgnore
    fun isInsert() = id == null

    @JsonIgnore
    fun isUpdate() = id != null

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true
        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as BaseEntity<*>

        return if (null == this.getId()) false else this.getId() == other.getId()
    }

}