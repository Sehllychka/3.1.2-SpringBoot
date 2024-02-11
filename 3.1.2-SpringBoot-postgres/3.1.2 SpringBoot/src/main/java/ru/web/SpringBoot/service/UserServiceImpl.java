package ru.web.SpringBoot.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web.SpringBoot.dao.UserDao;
import ru.web.SpringBoot.model.Person;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Person> getUser() {
        return userDao.getUser();
    }

    @Override
    @Transactional
    public void addUser(Person user) {
        userDao.addUser(user);
    }

    @Override
    public Person findByIdUser(long id) {
        return userDao.findByIdUser(id);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userDao.removeUser(id);
    }

    @Override
    @Transactional
    public void updateUser(Person user) {
        userDao.updateUser(user);
    }
}