package myteam.project4.repository;

import myteam.project4.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Transactional
public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Modifying
    @Query(value = "update Company set " +
            "name = :name, " +
            "area = :area, " +
            "authorizedCapital = :authorizedCapital, " +
            "fieldOfActivity = :fieldOfActivity, " +
            "floor = :floor, " +
            "hotline = :hotline, " +
            "taxCode = :taxCode " +
            "where  id = :id"
    )
    void updateById(Long id, String taxCode, Float authorizedCapital, String fieldOfActivity, String floor, String hotline, String name, Float area);
}
