package br.cubas.calculosalario.converter

import br.cubas.calculosalario.entity.WorkerEntity
import br.cubas.calculosalario.vo.WorkerVO

/**
 * @author s2it_csilva
 * @since 9/11/19 12:29 PM
 * @version : $<br/>
 *          : $
 *
 */
object WorkerConverter {

    fun toEntity(workerVO: WorkerVO, salary: Double, inss:Double, ir:Double, liquidSalary:Double): WorkerEntity {
        return WorkerEntity(
            null,
            workerVO.name,
            workerVO.timeToWork,
            workerVO.salaryHour,
            workerVO.dependents,
            salary,
            inss,
            ir,
            liquidSalary
        )
    }
}