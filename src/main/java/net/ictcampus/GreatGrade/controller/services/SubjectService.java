package net.ictcampus.GreatGrade.controller.services;

import net.ictcampus.GreatGrade.controller.repositories.SubjectRepository;
import net.ictcampus.GreatGrade.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Iterable<Subject> findByUserId(Integer userId) {
        return subjectRepository.findByUserId(userId);
    }

    public Iterable<Subject> findByNameAndUserId(String name, Integer userId) {
        return subjectRepository.findByNameAndUserId(name, userId);
    }

    public Subject findById(Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElseThrow(EntityNotFoundException::new);
    }

    public void insert(Subject subject) {
        subjectRepository.save(subject);
    }

    public void update(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }
}
