package myteam.project4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "building_employee")
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@EntityListeners(value = BaseModelListener.class)
public class BuildingEmployee extends BaseModel {

    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;

    @Column(name = "address", length = 250)
    private String address;

    @Column(name = "phone", length = 250)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_employee_id" )
    private List<MonthSalary> monthSalaryList;
}
