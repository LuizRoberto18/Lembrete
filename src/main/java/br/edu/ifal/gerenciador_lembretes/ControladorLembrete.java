package br.edu.ifal.gerenciador_lembretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class ControladorLembrete{       

    @Autowired
    RepositorioLembretes repoLembretes;

    Lembrete lembrete  = new Lembrete();

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }

    @RequestMapping("/formulario")
    public ModelAndView form(Lembrete lembrete){
        ModelAndView mv = new ModelAndView("formulario.html");
        mv.addObject("Lembrete", lembrete);
        return mv;
    }

    @RequestMapping("/cadastrar")
    public ModelAndView cadastrar(Lembrete lembrete, RedirectAttributes redirect){
        repoLembretes.save(lembrete);
    	ModelAndView mv = new ModelAndView("redirect:/lista");
    	redirect.addFlashAttribute("mensagem", lembrete.getDescricao() + " cadastrado com sucesso");
    	return mv;
    }
    @RequestMapping("/lista")
	public ModelAndView listarLembretes(){
		ModelAndView mv = new ModelAndView("lista.html");
		Iterable<Lembrete> lembretes = repoLembretes.findAll();
		mv.addObject("alunos", lembretes);
		return mv;
	}
    
}