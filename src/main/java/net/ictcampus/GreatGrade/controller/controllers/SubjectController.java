package net.ictcampus.GreatGrade.controller.controllers;

import net.ictcampus.GreatGrade.controller.services.SubjectService;
import net.ictcampus.GreatGrade.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public Iterable<Subject> findByName(@RequestParam(value = "name", required = false) String name) {
        try {
            if (!name.isEmpty()) {
                return subjectService.findByName(name);
            } else {
                return subjectService.findAll();
            }
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found");
        }
    }

    @GetMapping(path = "{id}")
    public Subject findById(@PathVariable(value = "id") Integer id) {
        try {
            return subjectService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subject not found");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid Subject subject) {
        try {
            subjectService.insert(subject);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't insert Subject");
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid Subject subject) {
        try {
            subjectService.update(subject);
        } catch(RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't update Subject");
        }
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(value = "id") Integer id) {
        try {
            subjectService.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Couldn't delete Subject");
        }
    }
}
