package it.corso.mygym.services;

import it.corso.mygym.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    //TODO findById(Long id)
    Optional<User> findById(Long id);

    //TODO findAll()
    List<User> findAll();

    //TODO update(Long id, User user)
    Optional<User> update(Long id, User user);

    Optional<User> deleteById(Long id);
}
