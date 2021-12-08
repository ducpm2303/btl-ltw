package myteam.project4.repository;

import myteam.project4.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findByPositionLike(String position);
    List<Salary> findAllByIsDeleted(boolean isDeleted);
    Optional<Salary> findByPositionAndLevel(String position, String level);
}
