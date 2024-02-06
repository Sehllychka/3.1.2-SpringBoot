package ru.web.SpringBoot.dao;


import ru.web.SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUser();
    void addUser(User user);
    User findByIdUser(long id);
    void removeUser (long id);
    void updateUser (User user);
}
