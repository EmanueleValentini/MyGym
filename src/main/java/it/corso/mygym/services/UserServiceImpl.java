package it.corso.mygym.services;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repo;
    @Override
    public User save(UserDto userDto) {
        //TODO controllare se la email dell'utente è già presente nel db
        if(repo.findByEmail(userDto.getEmail())!=null){
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return repo.save(modelMapper.map(userDto,User.class));
    }

    @Override
    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<User> findAll(boolean activeFlag) {
        return repo.findAll();
    }

    @Override
    public Optional<User> update(Long id, UserDto userDto) {
        Optional<User> existingUser = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        if (existingUser.isPresent()) {
            User updatedUser = repo.save(modelMapper.map(userDto,User.class));
            return Optional.of(updatedUser);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> deleteById(Long id) {
//TODO controllo che questo id esista --> se esiste allora lo cancello --> altrimenti ritorno un eccezione non found
        Optional<User> userToDelete = repo.findById(id);
        if (userToDelete.isPresent()) {
            repo.deleteById(id);
        }
        return userToDelete;
    }
}
