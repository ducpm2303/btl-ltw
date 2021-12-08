package myteam.project4.model.request;


import lombok.Data;

@Data
public class BuildingEmployeeRequest {
    private String name;
    private String dateOfBirth;
    private String address;
    private String phone;
    private String level;
    private String position;
}
