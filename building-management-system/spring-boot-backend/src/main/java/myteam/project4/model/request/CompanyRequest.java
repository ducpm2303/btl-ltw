package myteam.project4.model.request;

import lombok.Data;

@Data
public class CompanyRequest {
    private String name;
    private String taxCode;
    private Float authorizedCapital;
    private String fieldOfActivity;
    private String floor;
    private String hotline;
    private Float area;
}
