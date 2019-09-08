package br.cubas.calculosalario.entities

import javax.persistence.*

/**
 * @author s2it_csilva
 * @since 9/7/19 4:36 PM
 * @version : $<br/>
 *          : $
 *
 */
@Entity
data class Worker (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        var id: Long? = null,

        @Column(name = "NAME", length = 100, nullable = false)
        val name: String?,

        @Column(name = "TIME_TO_WORK")
        val timeToWork: Int = 0,

        @Column(name = "SALARY_HOUR")
        val salaryHour: Double = 0.0,

        @Column(name = "DEPENDENTS")
        val dependents: Int = 0,

        @Column(name = "SALARY")
        val salary: Double = 0.0,

        @Column(name = "INSS")
        val inss: Double = 0.0,

        @Column(name = "TAX")
        val tax: Double = 0.0,

        @Column(name = "FINAL_SALARY")
        val salaryFinal: Double = 0.0
)