package com.example.Project2Boot.dao;

import com.example.Project2Boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User readUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User user) {
        User userToBeUpdated = entityManager.find(User.class, id);;
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setSurname(user.getSurname());

        entityManager.merge(userToBeUpdated);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("SELECT u FROM User u").getResultList();
        return users;
    }
}
