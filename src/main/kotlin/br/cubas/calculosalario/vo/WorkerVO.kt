package br.cubas.calculosalario.vo

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * @author s2it_csilva
 * @since 9/7/19 4:36 PM
 * @version : $<br/>
 *          : $
 *
 */
data class WorkerVO (

        @field:NotNull @Size(min = 2, max = 100) var name: String,

        @field:NotNull @Min(1) var timeToWork: Int = 0,

        @field:NotNull var salaryHour: Double = 0.0,

        @field:NotNull val dependents: Int = 0
)