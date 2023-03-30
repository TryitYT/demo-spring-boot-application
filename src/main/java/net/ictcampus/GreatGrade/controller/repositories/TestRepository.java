package net.ictcampus.GreatGrade.controller.repositories;

import net.ictcampus.GreatGrade.model.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer> {
    @Query("SELECT t FROM Test t WHERE t.name LIKE CONCAT('%', :name, '%') AND t.subject.id_subject = :subjectId")
    Iterable<Test> findByNameAndSubjectId(@Param("name") String name, @Param("subjectId") Integer subjectId);

    @Query("SELECT t FROM Test t WHERE t.subject.id_subject = :subjectId")
    Iterable<Test> findBySubjectId(@Param("subjectId") Integer subjectId);
}
