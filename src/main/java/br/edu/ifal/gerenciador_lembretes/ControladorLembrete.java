package br.edu.ifal.gerenciador_lembretes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ControladorLembrete{

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @RequestMapping("/formulario")
    public ModelAndView form(){
        return new ModelAndView("formulario.html");
    }

    @RequestMapping("/lista")
    public ModelAndView lista(){
        return new ModelAndView("lista.html");
    }
}