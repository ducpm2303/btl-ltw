package myteam.project4.model.request;

import lombok.Data;

@Data
public class MaintenanceRequest extends ServiceRequest{
    private Long period;
}
