package ru.web.SpringBoot.dao;


import org.springframework.stereotype.Repository;
import ru.web.SpringBoot.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<Person> getUser() {
        return entityManager.createQuery(
                "from Person", Person.class).getResultList();
    }

    @Override
    public void addUser(Person user) {
        entityManager.persist(user);
    }



    @Override
    public Person findByIdUser(long id) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT u FROM Person u WHERE u.id = :userId", Person.class);
        query.setParameter("userId", id);
        List<Person> users = query.getResultList();
        if (users.isEmpty()) {
            throw new EntityNotFoundException("Не найден пользователь с Id = " + id);
        } else if (users.size() > 1) {
            throw new IllegalStateException("Найдено более одного пользователя с Id = " + id);
        }
        return users.get(0);
    }


    @Override
    public void removeUser(long id) {
        Person user = findByIdUser(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(Person user) {
        Person user1 = findByIdUser(user.getId());
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setAge(user.getAge());
    }
}

