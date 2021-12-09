package myteam.project4.controller;

import lombok.AllArgsConstructor;
import myteam.project4.model.request.UsedServiceRequest;
import myteam.project4.model.response.BaseResponse;
import myteam.project4.model.response.UsedServiceResponse;
import myteam.project4.service.UsedServiceBusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("public-api/v1.0.0/used_service")
@AllArgsConstructor
public class UsedServiceController {

    private final UsedServiceBusinessService usedService;
    @PostMapping("/create")
    BaseResponse<UsedServiceResponse> createUsedService(@RequestBody UsedServiceRequest request){
        return BaseResponse.ofSuccess(usedService.save(request));
    }


}
