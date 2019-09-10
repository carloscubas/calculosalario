package br.cubas.calculosalario.controller

import br.cubas.calculosalario.services.CalculatorService
import br.cubas.calculosalario.vo.WorkerVO
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

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
    fun process(@Valid worker: WorkerVO?, bindingResult: BindingResult): ModelAndView {

        if (bindingResult.hasErrors()) {
            return  ModelAndView("calculate/form");
        }

        worker?.let { calculatorService.process(it) }
        return ModelAndView("redirect:/")
    }


}
