package net.ictcampus.GreatGrade.controller.repositories;

import net.ictcampus.GreatGrade.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
