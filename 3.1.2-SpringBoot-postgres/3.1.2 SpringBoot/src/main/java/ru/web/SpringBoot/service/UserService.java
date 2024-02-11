package ru.web.SpringBoot.service;


import ru.web.SpringBoot.model.Person;

import java.util.List;

public interface UserService {
    List<Person> getUser();

    void addUser(Person user);

    Person findByIdUser(long id);

    void removeUser(long id);

    void updateUser(Person user);
}
