package br.cubas.calculosalario.controller

import br.cubas.calculosalario.services.CalculatorService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class IndexController (
        private val calculatorService: CalculatorService
) {

    @GetMapping
    fun index(): ModelAndView {
        return ModelAndView("home/index", "workers", calculatorService.getWorkers())
    }
}