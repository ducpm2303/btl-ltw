package myteam.project4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "building", schema = "btl_ltw")
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@EntityListeners(value = BaseModelListener.class)
public class Building extends BaseModel {

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "address", length = 200)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "building")
    private List<BuildingEmployee> buildingEmployeeList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "building")
    private List<Company> companyList;
}
