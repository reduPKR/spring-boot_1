package com.exercicio2.aula2.repository;

import com.exercicio2.aula2.model.Person;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    private final ArrayList<Person> list;

    public PersonRepository() {
        list = new ArrayList();
        list.add(new Person("Rafael","Eduardo",26));
    }
    
    public ArrayList<Person> getAll(){
        return list;
    }
    
    public void add(final Person p){
        list.add(p);
    }
}
