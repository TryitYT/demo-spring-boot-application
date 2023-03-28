package net.ictcampus.GreatGrade.controller.repositories;

import net.ictcampus.GreatGrade.model.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    @Query("SELECT s FROM Subject s WHERE s.name LIKE CONCAT('%', :name, '%')")
    Iterable<Subject> findByName(@Param("name") String name);
}
