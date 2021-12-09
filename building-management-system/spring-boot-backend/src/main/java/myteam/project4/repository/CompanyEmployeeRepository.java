package myteam.project4.repository;

import myteam.project4.entity.CompanyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployee, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "update CompanyEmployee set " +
//            "code = :code, " +
//            "dateOfBirth = :dateOfBirth, " +
//            "identification = :identification, " +
//            "name = :name, " +
//            "phone = :phone, " +
//            "company.id = :company_id " +
//            "where id = :id"
//    )
//    void updateById(Long id, String code, Timestamp dateOfBirth, String identification, String name, String phone, Long company_id);

    List<CompanyEmployee> findCompanyEmployeeByIsDeletedAndCompanyId(boolean isDeleted, Long company_id);

    List<CompanyEmployee> findAllByIsDeleted(boolean isDeleted);

    List<CompanyEmployee> findCompanyEmployeeByCompanyIdAndIsDeletedAndNameLike(Long companyId, boolean isDeleted, String name);
}
