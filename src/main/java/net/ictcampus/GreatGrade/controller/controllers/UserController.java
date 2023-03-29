package net.ictcampus.GreatGrade.controller.controllers;

import net.ictcampus.GreatGrade.controller.services.UserService;
import net.ictcampus.GreatGrade.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> findAll() {
        try {
            return userService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users not found");
        }
    }

    @GetMapping(path = "{id}")
    public User findById(@PathVariable(value = "id") Integer id) {
        try {
            return userService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


    @PostMapping(value = "/sign-up", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid User user) {
        try {
            userService.signUp(user);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't create User");
        }
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid User user) {
        try {
            userService.update(user);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't update User");
        }
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Integer id) {
        try {
            userService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't delete User");
        }
    }
}
