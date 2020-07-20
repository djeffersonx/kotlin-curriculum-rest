package br.com.djefferson.repository

import br.com.djefferson.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceRepository : JpaRepository<Resource, Long>

@Repository
interface CityRepository : JpaRepository<City, Long>

@Repository
interface StateRepository : JpaRepository<State, Long>

@Repository
interface SkillRepository : JpaRepository<Skill, Long>

@Repository
interface ExperienceRepository : JpaRepository<Experience, Long>