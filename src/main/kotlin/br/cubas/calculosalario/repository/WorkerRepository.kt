package br.cubas.calculosalario.repository

import br.cubas.calculosalario.entity.WorkerEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkerRepository : JpaRepository<WorkerEntity, Long>