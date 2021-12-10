package myteam.project4.controller;

import lombok.AllArgsConstructor;
import myteam.project4.model.response.BaseResponse;
import myteam.project4.model.response.BuildingEmployeeResponse;
import myteam.project4.model.response.MonthSalaryResponse;
import myteam.project4.service.MonthSalaryService;
import myteam.project4.service.implement.MonthSalaryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("public-api/v1.0.0/month-salary")
@AllArgsConstructor
public class MonthSalaryController {

    private final MonthSalaryService monthSalaryService;

    @GetMapping()
    BaseResponse<List<BuildingEmployeeResponse>> getAllMonthSalaryPrecent() {
        return BaseResponse.ofSuccess(monthSalaryService.getAllMonthSalaryPrecent(false));
    }


}
