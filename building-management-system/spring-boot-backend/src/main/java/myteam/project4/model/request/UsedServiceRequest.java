package myteam.project4.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsedServiceRequest {

    private Long companyId;

    private Long ServiceId;

}
