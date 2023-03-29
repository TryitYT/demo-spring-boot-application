package net.ictcampus.GreatGrade.controller.services;

import net.ictcampus.GreatGrade.controller.configurations.ApplicationConfiguration;
import net.ictcampus.GreatGrade.controller.repositories.UserRepository;
import net.ictcampus.GreatGrade.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ApplicationConfiguration applicationConfiguration) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = applicationConfiguration.bCryptPasswordEncoder();
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    public void signUp(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void update(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
