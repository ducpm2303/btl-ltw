package myteam.project4.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "used_service")
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@EntityListeners(value = BaseModelListener.class)
public class UsedService extends BaseModel{

    @Column(name = "start_date")
    private Timestamp startDate;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "service_id")
    private Service service;

//    @ManyToOne()
//    @JoinColumn(name = "food_service_id")
//    private FoodService foodService;
//
//    @ManyToOne()
//    @JoinColumn(name = "maintenance_service_id")
//    private MaintenanceService maintenanceService;
//
//    @ManyToOne()
//    @JoinColumn(name = "parking_service")
//    private ParkingService parkingService;
//
//    @ManyToOne()
//    @JoinColumn(name = "protected_service")
//    private ProtectedService protectedService;
//
//    @ManyToOne()
//    @JoinColumn(name = "cleaned_service_id")
//    private CleanedService cleanedService;
}
