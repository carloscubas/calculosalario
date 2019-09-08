package br.cubas.calculosalario.services

import br.cubas.calculosalario.entities.Worker
import org.springframework.stereotype.Service

/**
 * @author s2it_csilva
 * @since 9/8/19 8:33 PM
 * @version : $<br/>
 *          : $
 *
 */
@Service
class CalculatorService {

    fun process(worker:Worker): Worker{
        worker.salary = normalSalary(worker)
        worker.inss = inss(worker)
        worker.tax = ir(worker)
        worker.salaryFinal = liquidSalary(worker)

        return worker
    }

    fun normalSalary(worker:Worker):Double {
        return worker.timeToWork * worker.salaryHour + (50 * worker.dependents)
    }

    private fun inss(worker:Worker):Double {
        if(worker.salary <= 1000.0){
            return worker.salary * 8.5/100
        }else{
            return worker.salary * 9/100
        }
    }

    private fun ir(worker:Worker):Double {
        if(worker.salary <= 500.0){
            return 0.0
        }else if(worker.salary > 500 && worker.salary <= 1000.0){
            return worker.salary * 5/100
        }else{
            return worker.salary * 7/100
        }
    }

    private fun liquidSalary(worker:Worker):Double {
        return worker.salary - worker.inss - worker.tax
    }

}