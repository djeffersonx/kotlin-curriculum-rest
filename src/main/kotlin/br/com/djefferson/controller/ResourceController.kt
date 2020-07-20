package br.com.djefferson.controller

import br.com.djefferson.model.Resource
import br.com.djefferson.repository.ResourceRepository
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/resources")
class ResourceController(private val resourceRepository: ResourceRepository) {

    @PostMapping
    fun save(@RequestBody resource: Resource): ResponseEntity<Resource> {
        return ResponseEntity.ok(resourceRepository.save(resource))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return resourceRepository.findById(id).map { resource ->
            resourceRepository.delete(resource)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping
    fun getAllResources(): List<Resource> {
        return resourceRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<Resource> {
        return resourceRepository.findById(id).map { r ->
            ResponseEntity.ok(r)
        }.orElse(ResponseEntity.notFound().build())
    }

}