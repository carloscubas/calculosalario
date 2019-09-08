package br.cubas.calculosalario.controller

import br.cubas.calculosalario.entities.Worker
import br.cubas.calculosalario.services.CalculatorService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/calculator")
class CalculatorController (
        private val calculatorService: CalculatorService
){

    @GetMapping("/new")
    fun index(): ModelAndView {
        return ModelAndView("calculate/form")
    }

    @PostMapping("/process")
    fun process(worker: Worker): ModelAndView {

        return ModelAndView("redirect:/")
    }


}