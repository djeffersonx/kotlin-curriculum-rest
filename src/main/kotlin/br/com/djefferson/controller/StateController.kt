package br.com.djefferson.controller

import br.com.djefferson.model.State
import br.com.djefferson.repository.StateRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/states")
class StateController(private val stateRepository: StateRepository) {

    @PostMapping
    fun save(@RequestBody state: State): ResponseEntity<State> {
        return ResponseEntity.ok(stateRepository.save(state))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return stateRepository.findById(id).map { state ->
            stateRepository.delete(state)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping
    fun getAllStates(): List<State> {
        return stateRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<State> {
        return stateRepository.findById(id).map { r ->
            ResponseEntity.ok(r)
        }.orElse(ResponseEntity.notFound().build())
    }

}