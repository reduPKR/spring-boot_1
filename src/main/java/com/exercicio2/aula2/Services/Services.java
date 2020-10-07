package com.exercicio2.aula2.Services;

import com.exercicio2.aula2.Exceptions.PersonNotFoundException;
import com.exercicio2.aula2.model.Person;
import com.exercicio2.aula2.repository.PersonRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
    @Autowired
    private PersonRepository repository;

    public ArrayList<Person> getAll() {
        return repository.getAll();
    }

    public Person getById(int id) {
        final Optional<Person> p = repository.getById(id);
        if(p.isPresent()){
            return p.get();
        }
        throw new PersonNotFoundException();
    }

    public Person add(Person p) {
        return repository.add(p);
    }

    public Person update(int id, Person p) {
        Person person = repository.update(id,p);
        
        if(person != null){
            return person;
        }
        throw new PersonNotFoundException();        
    }

    public void delete(int id) {
        Optional<Person> p = repository.getById(id);
        repository.delete(p.get());
    }
    
    
}
