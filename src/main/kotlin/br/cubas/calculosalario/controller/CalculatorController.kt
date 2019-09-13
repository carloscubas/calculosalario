package br.cubas.calculosalario.controller

import br.cubas.calculosalario.services.CalculatorService
import br.cubas.calculosalario.vo.WorkerVO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.validation.Valid

@Controller
@RequestMapping("/calculator")
class CalculatorController (
        private val calculatorService: CalculatorService
){

    @GetMapping("/new")
    fun index(): ModelAndView {
        return ModelAndView("calculate/form", "worker", WorkerVO(null, null, 0, 0.0, 0))
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): ModelAndView {
        calculatorService.delete(id)
        return ModelAndView("redirect:/")
    }

    @GetMapping("/update/{id}")
    fun update(@PathVariable("id") id: Long): ModelAndView {
        return  ModelAndView("calculate/form", "worker", calculatorService.getWorker(id))
    }

    @PostMapping("/process")
    fun process(@Valid @ModelAttribute("worker") worker: WorkerVO, bindingResult: BindingResult, model: Model): ModelAndView {
        if (bindingResult.hasErrors()) {
            return  ModelAndView("calculate/form")
        }
        calculatorService.process(worker)
        return ModelAndView("redirect:/")
    }
}
