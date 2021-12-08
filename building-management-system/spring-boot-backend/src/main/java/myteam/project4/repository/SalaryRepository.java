package myteam.project4.repository;

import myteam.project4.entity.BuildingEmployee;
import myteam.project4.entity.MonthSalary;
import myteam.project4.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findByPositionLike(String position);
    List<Salary> findAllByIsDeleted(boolean isDeleted);
}
