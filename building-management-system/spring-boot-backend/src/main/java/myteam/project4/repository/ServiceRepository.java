package myteam.project4.repository;

import myteam.project4.entity.CleanedService;
import myteam.project4.entity.MaintenanceService;
import myteam.project4.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Optional<CleanedService> findCleanedServiceByActiveIs(boolean active);

    @Transactional
    @Modifying
    @Query("UPDATE Service service SET service.active = false WHERE service.id IN (SELECT c.id FROM CleanedService c)")
    void deactivateAllCleanedService();

    Optional<MaintenanceService> findMaintenanceServiceByActiveIs(boolean active);

    @Transactional
    @Modifying
    @Query("UPDATE Service service SET service.active = false WHERE service.id IN (SELECT m.id FROM MaintenanceService m)")
    void deactivateAllMaintenanceService();
}
