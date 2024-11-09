package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom",24,"tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",52,"bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18,"mike@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy",34,"katy@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToUpdate=show(id);

        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setAge(updatedPerson.getAge());
        personToUpdate.setEmail(updatedPerson.getEmail());
    }
    public void delete(int id){
        people.removeIf(person -> person.getId()==id);
    }
}
