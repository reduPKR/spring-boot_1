package com.exercicio2.aula2.rest;

import com.exercicio2.aula2.model.Person;
import com.exercicio2.aula2.repository.PersonRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaResources {
    @Autowired
    private PersonRepository repository;
    
    @GetMapping("/api")
    public String get(){
        return "Olá";
    }
    
    @GetMapping("/api/pessoa")
    public ArrayList<Person> getAll(){
        return repository.getAll();
    }
    
    @GetMapping("/api/pessoa/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        final Optional<Person> p = repository.getById(id);
        if(p.isPresent()){
            return ResponseEntity.ok(p.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     *
     * @param p
     * @return
     */
    @PostMapping("/api/pessoa")
    public Person create(@RequestBody Person p){
        return repository.add(p);
    }
    
    /**
     *
     * @param p
     * @param id
     * @return
     */
    @PutMapping("/api/pessoa/{id}")
    public ResponseEntity<Person> update(@RequestBody Person p, @PathVariable("id") int id){   
        Person person = repository.update(id,p);
        
        if(person != null){
            return ResponseEntity.ok(person);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/api/pessoa/{id}")
    public ResponseEntity<Person> delete(@PathVariable("id") int id){
        Optional<Person> p = repository.getById(id);
        if(p.isPresent()){
            repository.delete(p.get());
            return ResponseEntity.noContent().build();
        }else
            return ResponseEntity.notFound().build();
    }
}
