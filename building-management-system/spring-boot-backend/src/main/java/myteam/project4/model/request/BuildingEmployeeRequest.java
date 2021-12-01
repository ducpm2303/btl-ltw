package myteam.project4.model.request;


import lombok.Data;
import myteam.project4.entity.MonthSalary;
import myteam.project4.entity.Salary;

@Data
public class BuildingEmployeeRequest {
    private String code;
    private String name;
    private String dateOfBirth;
    private String address;
    private String phone;
    private String level;
    private String position;
    private Float salary;
}
