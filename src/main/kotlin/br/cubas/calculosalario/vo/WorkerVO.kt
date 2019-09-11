package br.cubas.calculosalario.vo

import javax.validation.constraints.Min
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

/**
 * @author s2it_csilva
 * @since 9/7/19 4:36 PM
 * @version : $<br/>
 *          : $
 *
 */
data class WorkerVO (

        @field:NotEmpty @Size(min = 2, max = 100) var name: String,

        @field:Min(1) var timeToWork: Int = 0,

        @field:Min(1) var salaryHour: Double = 0.0,

       var dependents: Int = 0
)