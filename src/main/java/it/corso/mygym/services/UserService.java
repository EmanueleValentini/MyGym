package it.corso.mygym.services;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(UserDto userDto);

    //TODO findById(Long id)
    Optional<User> findById(Long id) throws UserNotFoundException;

    //TODO findAll()
    List<User> findAll(boolean activeFlag);

    //TODO update(Long id, User user)
    Optional<User> update(Long id, UserDto userDto) throws UserNotFoundException;

    void validateExist(Long id);

    Optional<User> deleteById(Long id);
}
