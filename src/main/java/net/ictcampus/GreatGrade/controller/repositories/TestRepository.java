package net.ictcampus.GreatGrade.controller.repositories;

import net.ictcampus.GreatGrade.model.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {
    @Query("SELECT t FROM Test t WHERE t.name LIKE CONCAT('%', :name, '%')")
    Iterable<Test> findByName(@Param("name") String name);
}
