package net.ictcampus.GreatGrade.controller.services;

import net.ictcampus.GreatGrade.controller.configurations.ApplicationConfiguration;
import net.ictcampus.GreatGrade.controller.repositories.UserRepository;
import net.ictcampus.GreatGrade.model.Users;
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

    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findById(Integer id) {
        Optional<Users> user = userRepository.findById(id);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    public void signUp(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userRepository.save(users);
    }

    public void update(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userRepository.save(users);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
