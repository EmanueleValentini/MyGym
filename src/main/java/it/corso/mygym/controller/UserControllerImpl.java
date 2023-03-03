package it.corso.mygym.controller;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController{
    @Autowired
    private UserService userService;

    public UserControllerImpl(final UserService userService){
        this.userService=userService;
    };
    @PostMapping()
    @Override
    public ResponseEntity<User> save(@RequestBody UserDto userDto) {
        User userSaved = userService.save(userDto);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Optional<User>> findById(@PathVariable("id") Long id) {
        Optional<User> userFind = userService.findById(id);
        return new ResponseEntity<>(userFind,HttpStatus.FOUND);
    }

    @GetMapping()
    @Override
    public ResponseEntity<List<User>> findAll(boolean activeFlag) {
        List<User> users = userService.findAll(activeFlag);
        return  new ResponseEntity<>(users,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Optional<User>> update(@PathVariable("id") Long id,@RequestBody UserDto userDto) {
        Optional<User> userFound = userService.update(id,userDto);
        return new ResponseEntity<>(userFound,HttpStatus.ACCEPTED);
    }


}
