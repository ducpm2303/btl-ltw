package myteam.project4.repository;

import myteam.project4.entity.BuildingEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface BuildingEmployeeRepository extends JpaRepository<BuildingEmployee, Long> {

    List<BuildingEmployee> findByNameLike(String name);
    List<BuildingEmployee> findAllByIsDeleted(boolean isDeleted);

    @Query(value = "SELECT Max(b.id) FROM BuildingEmployee b")
    Optional<Integer> findLastId();
}
