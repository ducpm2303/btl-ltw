package myteam.project4.model.request;

import lombok.Data;

@Data
public class ParkingServiceRequest extends ServiceRequest{
    private Long slot;
}
