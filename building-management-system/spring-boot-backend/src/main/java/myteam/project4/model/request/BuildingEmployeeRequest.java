package myteam.project4.model.request;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BuildingEmployeeRequest {

    @NotNull
    private String name;
    @NotNull
    private String dateOfBirth;
    private String address;
    private String phone;
    @NotNull
    private String level;
    @NotNull
    private String position;
}
