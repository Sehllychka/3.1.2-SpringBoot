package ru.web.SpringBoot.dao;


import ru.web.SpringBoot.model.Person;

import java.util.List;

public interface UserDao {
    List<Person> getUser();
    void addUser(Person user);
    Person findByIdUser(long id);
    void removeUser (long id);
    void updateUser (Person user);
}
