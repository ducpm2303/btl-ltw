package myteam.project4.model.request;

import lombok.Data;

@Data
public class SalaryRequest {
    private String level;
    private String position;
    private Float salary;
}
