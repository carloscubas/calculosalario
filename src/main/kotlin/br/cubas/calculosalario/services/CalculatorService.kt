package br.cubas.calculosalario.services

import br.cubas.calculosalario.converter.WorkerConverter
import br.cubas.calculosalario.entity.WorkerEntity
import br.cubas.calculosalario.repository.WorkerRepository
import br.cubas.calculosalario.vo.WorkerVO
import org.springframework.stereotype.Service

/**
 * @author s2it_csilva
 * @since 9/8/19 8:33 PM
 * @version : $<br/>
 *          : $
 *
 */
@Service
class CalculatorService(
        private val workerRepository: WorkerRepository
) {

    fun getWorkers(): List<WorkerEntity>{
        return workerRepository.findAll()
    }

    fun process(workerVO: WorkerVO): WorkerEntity{
        var worker = WorkerConverter.toEntity(workerVO,
                normalSalary(workerVO),
                inss(workerVO),
                ir(workerVO),
                liquidSalary(workerVO))
        workerRepository.save(worker)
        return worker
    }

    fun normalSalary(workerVO:WorkerVO):Double {
        return workerVO.timeToWork * workerVO.salaryHour + (50 * workerVO.dependents)
    }

    private fun inss(workerVO:WorkerVO):Double {
        return if(normalSalary(workerVO) <= 1000.0){
            normalSalary(workerVO) * 8.5/100
        }else normalSalary(workerVO) * 9/100
    }

    private fun ir(workerVO:WorkerVO):Double {
        return if(normalSalary(workerVO) <= 500.0){
            0.0
        }else if(normalSalary(workerVO) > 500 && normalSalary(workerVO) <= 1000.0){
            normalSalary(workerVO) * 5/100
        }else{
            normalSalary(workerVO) * 7/100
        }
    }

    private fun liquidSalary(workerVO:WorkerVO):Double {
        return normalSalary(workerVO) - inss(workerVO) - ir(workerVO)
    }

    fun delete(id: Long) {
        workerRepository.deleteById(id)
    }
}