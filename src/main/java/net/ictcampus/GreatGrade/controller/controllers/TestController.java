package net.ictcampus.GreatGrade.controller.controllers;

import net.ictcampus.GreatGrade.controller.services.TestService;
import net.ictcampus.GreatGrade.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public Iterable<Test> findByName(@RequestParam(value = "name", required = false) String name) {
        try {
            if (!name.isEmpty()) {
                return testService.findByName(name);
            } else {
                return testService.findAll();
            }
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }

    @GetMapping(path = "{id}")
    public Test findById(@PathVariable(value = "id") Integer id) {
        try {
            return testService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid Test test) {
        try {
            testService.insert(test);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't insert Test");
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid Test test) {
        try {
            testService.update(test);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't update Subject");
        }
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Integer id) {
        try {
            testService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't delete Subject");
        }
    }
}
