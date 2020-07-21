package br.com.djefferson.controller

import br.com.djefferson.model.City
import br.com.djefferson.repository.CityRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/citys")
class CityController(private val cityRepository: CityRepository) {

    @PostMapping
    fun save(@RequestBody city: City): ResponseEntity<City> {
        return ResponseEntity.ok(cityRepository.save(city))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return cityRepository.findById(id).map { city ->
            cityRepository.delete(city)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping
    fun getAllCitys(): List<City> {
        return cityRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<City> {
        return cityRepository.findById(id).map { r ->
            ResponseEntity.ok(r)
        }.orElse(ResponseEntity.notFound().build())
    }

}