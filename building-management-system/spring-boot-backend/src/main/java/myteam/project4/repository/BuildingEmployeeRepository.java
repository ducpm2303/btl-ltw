package myteam.project4.repository;

import myteam.project4.entity.BuildingEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
public interface BuildingEmployeeRepository extends JpaRepository<BuildingEmployee, Long> {

    @Modifying
    @Query(value = "update BuildingEmployee set " +
            "code = :code, " +
            "address = :address, " +
            "dateOfBirth = :dateOfBirth, " +
            "level = :level, " +
            "position = :position, " +
            "name = :name, " +
            "phone = :phone " +
            "where id = :id")
    void updateById(Long id, String code, Timestamp dateOfBirth, String address, String level, String position, String name, String phone);

    List<BuildingEmployee> findByNameLike(String name);
}
