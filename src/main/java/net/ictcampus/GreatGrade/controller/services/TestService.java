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

    public Iterable<Test> findBySubjectId(Integer subjectId) {
        return testRepository.findBySubjectId(subjectId);
    }

    public Iterable<Test> findByNameAndSubjectId(String name, Integer subjectId) {
        return testRepository.findByNameAndSubjectId(name, subjectId);
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
