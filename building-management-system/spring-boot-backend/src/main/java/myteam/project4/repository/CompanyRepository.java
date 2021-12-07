package myteam.project4.repository;

import myteam.project4.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Transactional
    @Modifying
    @Query(value = "update Company company set " +
            "company.name = :name, " +
            "company.area = :area, " +
            "company.authorizedCapital = :authorizedCapital, " +
            "company.fieldOfActivity = :fieldOfActivity, " +
            "company.floor = :floor, " +
            "company.hotline = :hotline, " +
            "company.taxCode = :taxCode " +
            "where  company.id = :id"
    )
    void updateById(Long id, String taxCode, Float authorizedCapital, String fieldOfActivity, String floor, String hotline, String name, Float area);
}
