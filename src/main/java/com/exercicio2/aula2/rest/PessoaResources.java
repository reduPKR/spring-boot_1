package com.exercicio2.aula2.rest;

import com.exercicio2.aula2.Services.Services;
import com.exercicio2.aula2.model.Person;
import com.exercicio2.aula2.repository.PersonRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaResources {
    @Autowired
    private Services service;
    
    @GetMapping("/api")
    public String get(){
        return "Olá";
    }
    
    @GetMapping("/api/pessoa")
    public ArrayList<Person> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/api/pessoa/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        Person p = service.getById(id);
        return ResponseEntity.ok(p);
    }
    
    /**
     *
     * @param p
     * @return
     */
    @PostMapping("/api/pessoa")
    public Person create(@RequestBody Person p){
        return service.add(p);
    }
    
    /**
     *
     * @param p
     * @param id
     * @return
     */
    @PutMapping("/api/pessoa/{id}")
    public ResponseEntity<Person> update(@RequestBody Person p, @PathVariable("id") int id){   
        Person person = service.update(id,p);
        return ResponseEntity.ok(person);
    }
    
    @DeleteMapping("/api/pessoa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
    
    
}
