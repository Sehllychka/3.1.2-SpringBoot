package ru.web.SpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.web.SpringBoot.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext()
    EntityManager entityManager;

    @Override
    public List<User> getUser() {
        return entityManager.createQuery(
                "from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findByIdUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(long id) {
        User user = findByIdUser(id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        User user1 = findByIdUser(user.getId());
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setAge(user.getAge());
    }
}
