package myteam.project4.model.response;

import lombok.Data;

@Data
public class CompanyResponse {
    private Long id;
    private String name;
    private String taxCode;
    private String authorizedCapital;
    private String fieldOfActivity;
    private String floor;
    private String hotline;
    private Float area;
}
