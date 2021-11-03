package myteam.project4.model.request;

import lombok.Data;


@Data
public class CompanyEmployeeRequest {
    private String code;
    private String identification;
    private String name;
    private String dateOfBirth;
    private String phone;
    private Long company_id;
}
