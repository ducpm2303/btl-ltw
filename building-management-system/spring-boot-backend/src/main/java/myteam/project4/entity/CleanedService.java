package myteam.project4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cleaned_service")
@PrimaryKeyJoinColumn(name = "service_id")
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@EntityListeners(value = BaseModelListener.class)
public class CleanedService extends  Service{

    @Column(name = "any")
    private String any;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cleaned_service")
//    private List<UsedService> usedServiceList;
}