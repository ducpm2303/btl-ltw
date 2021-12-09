package myteam.project4.repository;

import myteam.project4.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findByIsDeletedAndPositionLike(Boolean isDeleted, String position);
    List<Salary> findAllByIsDeleted(boolean isDeleted);
    Optional<Salary> findByPositionAndLevel(String position, String level);
    @Query(value = "SELECT distinct (s.position) FROM Salary s")
    List<String> findAllPosition();
    @Query(value = "SELECT s.level FROM Salary  s WHERE s.position = :position")
    List<String> findAllLevelByPosition(String position);
}
