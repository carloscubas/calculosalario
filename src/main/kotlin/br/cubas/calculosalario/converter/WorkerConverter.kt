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
        return WorkerEntity(workerVO.id,
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

    fun toVo(workerEntity:  WorkerEntity): WorkerVO {
        return WorkerVO(
                workerEntity.id,
                workerEntity.name,
                workerEntity.timeToWork,
                workerEntity.salaryHour,
                workerEntity.dependents
        )
    }
}