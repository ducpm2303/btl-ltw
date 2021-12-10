package myteam.project4.repository;

import myteam.project4.entity.MonthUsedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface MonthUsedServiceRepository extends JpaRepository<MonthUsedService, Long> {

    @Query(value = "SELECT m.* FROM month_used_service m INNER JOIN used_service us ON m.used_service_id = us.id" +
            " WHERE us.company_id = :companyId and :date >= from_date AND :date <  to_date", nativeQuery = true)
    List<MonthUsedService> findByCompanyIdAndDate(Long companyId, Timestamp date);
}
