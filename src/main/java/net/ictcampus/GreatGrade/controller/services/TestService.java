package net.ictcampus.GreatGrade.controller.services;

import net.ictcampus.GreatGrade.controller.repositories.TestRepository;
import net.ictcampus.GreatGrade.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Iterable<Test> findAll() {
        return testRepository.findAll();
    }

    public Iterable<Test> findByName(String name) {
        return testRepository.findByName(name);
    }

    public Test findById(Integer id) {
        Optional<Test> test = testRepository.findById(id);
        return test.orElseThrow(EntityNotFoundException::new);
    }

    public void insert(Test test) {
        testRepository.save(test);
    }

    public void update(Test test) {
        testRepository.save(test);
    }

    public void deleteById(Integer id) {
        testRepository.deleteById(id);
    }
}
