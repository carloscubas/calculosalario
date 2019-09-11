package br.cubas.calculosalario.entity

import javax.persistence.*
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
@Entity
@Table(name = "Worquer")
data class WorkerEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        var id: Long? = null,

        @NotNull
        @Size(min = 2, max = 100)
        @Column(name = "NAME", length = 100, nullable = false)
        val name: String?,

        @NotNull
        @Min(1)
        @Column(name = "TIME_TO_WORK")
        var timeToWork: Int = 0,

        @NotNull
        @Column(name = "SALARY_HOUR")
        var salaryHour: Double = 0.0,

        @NotNull
        @Column(name = "DEPENDENTS")
        var dependents: Int = 0,

        @Column(name = "SALARY")
        var salary: Double = 0.0,

        @Column(name = "INSS")
        var inss: Double = 0.0,

        @Column(name = "TAX")
        var tax: Double = 0.0,

        @Column(name = "FINAL_SALARY")
        var salaryFinal: Double = 0.0
)