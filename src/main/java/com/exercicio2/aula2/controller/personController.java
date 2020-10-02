package com.exercicio2.aula2.controller;

import com.exercicio2.aula2.model.Person;
import com.exercicio2.aula2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class personController {
    @Autowired
    private PersonRepository repository;//Nesse curso ainda nao usa banco
    
    @GetMapping("/pessoa")
    public ModelAndView getPersons(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("person");        
        mv.addObject("persons",repository.getAll());
        return mv;
    }      
    
    @GetMapping("/nova/pessoa")
    public ModelAndView getPerson(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("new-person");
        
        mv.addObject("person", new Person());
        return mv;
    }
    
    /**
     *
     * @param p
     * @return
     */
    @PostMapping("/pessoa")
    public ModelAndView setPessoa(@ModelAttribute Person p){
        repository.add(p);  
        return new ModelAndView("redirect:pessoa");
    }
}
