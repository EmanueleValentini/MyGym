package it.corso.mygym.services;

import it.corso.mygym.Constants;
import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.exceptions.UserNotFoundException;
import it.corso.mygym.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        validateExist(id);
        return repo.findById(id);
    }

    @Override
    public List<User> findAll(boolean activeFlag) {
        return repo.findAll();
    }

    @Override
    public User update(Long id, UserDto userDto) {
        validateExist(id); // may throw the UserNotFoundException
        User userEntity = repo.findById(id).get();
        copyNonNullProperties(userDto, userEntity);
        return repo.saveAndFlush(userEntity);
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

    public void validateExist(Long id){
        if(repo.findById(id).isEmpty()) throw new UserNotFoundException(Constants.USER_NOT_FOUND_EXCEPTION,id);
    }
    static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
