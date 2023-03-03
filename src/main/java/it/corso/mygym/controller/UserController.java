package it.corso.mygym.controller;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
public interface UserController {
    @PostMapping()
    ResponseEntity<User> save(@RequestBody UserDto userDto);

    @GetMapping("/{id}")
    ResponseEntity<Optional<User>> findById(@PathVariable("id") Long id);

    @GetMapping()
    ResponseEntity<List<User>> findAll(boolean activeFlag);

    @PutMapping("/{id}")
    ResponseEntity<Optional<User>> update(@PathVariable("id") Long id, @RequestBody UserDto userDto);
}
