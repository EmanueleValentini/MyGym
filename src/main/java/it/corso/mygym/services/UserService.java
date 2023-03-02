package it.corso.mygym.services;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(UserDto userDto);

    //TODO findById(Long id)
    Optional<User> findById(Long id);

    //TODO findAll()
    List<User> findAll();

    //TODO update(Long id, User user)
    Optional<User> update(Long id, UserDto userDto);

    Optional<User> deleteById(Long id);
}
