package com.exercicio2.aula2.repository;

import com.exercicio2.aula2.model.Person;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    private final ArrayList<Person> list;
    private int lastId;

    public PersonRepository() {
        list = new ArrayList();
        list.add(new Person(1,"Rafael","Eduardo",26));
        lastId = 1;
    }
    
    public ArrayList<Person> getAll(){
        return list;
    }
    
    public Optional<Person> getById(int id){
	return list.stream().filter(item -> item.getId() == id).findFirst();
    }
    
    public Person add(Person p){
        p.setId(++lastId);
        list.add(p);
        return p;
    }
    
    public Person update(int id, Person p){
        Optional<Person> aux = list.stream().filter(item -> item.getId() == id).findFirst();
        
        if(aux.isPresent()){
            Person person = aux.get();
            person.setAge(p.getAge());
            person.setName(p.getName());
            person.setLastName(p.getLastName());
            
            return person;
        }
        return null;
    }
    
    public void delete(Person p){
        list.remove(p);
    }
}
