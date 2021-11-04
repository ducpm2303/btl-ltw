package myteam.project4.model.request;

import lombok.Data;

@Data
public class BuildingEmployeeRequest {
    private String code;
    private String name;
    private String dateOfBirth;
    private String address;
    private String phone;
    private String position;
    private String level;
    private Long building_id;
}
