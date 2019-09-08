package br.cubas.calculosalario.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/")
class IndexController {

    @GetMapping
    fun index(): ModelAndView {
        return ModelAndView("home/index")
    }
}