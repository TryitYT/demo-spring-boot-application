package net.ictcampus.GreatGrade.controller.repositories;

import net.ictcampus.GreatGrade.model.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    @Query("SELECT s FROM Subject s WHERE s.name LIKE CONCAT('%', :name, '%') AND s.users.id_user = :userId")
    Iterable<Subject> findByNameAndUserId(@Param("name") String name, @Param("userId") Integer userId);

    @Query("SELECT s FROM Subject s WHERE s.users.id_user = :userId")
    Iterable<Subject> findByUserId(@Param("userId") Integer userId);
}
