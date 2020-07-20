package br.com.djefferson.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/resource")
class ResourceController {

    @GetMapping
    fun get(@RequestParam(value = "name") name: String) = mapOf("name" to name)

}