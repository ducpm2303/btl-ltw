package myteam.project4.mapper;

import myteam.project4.entity.MonthSalary;
import myteam.project4.entity.Salary;
import myteam.project4.model.request.MonthSalaryRequest;
import myteam.project4.model.request.SalaryRequest;
import myteam.project4.model.response.MonthSalaryResponse;
import myteam.project4.model.response.SalaryResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MonthSalaryMapper implements Mapper<MonthSalary>{

    public MonthSalary to(MonthSalaryRequest request) {
        MonthSalary monthSalary = new MonthSalary();
        BeanUtils.copyProperties(request, monthSalary);
        return monthSalary;
    }

    public MonthSalaryResponse to(MonthSalary monthSalary) {
        MonthSalaryResponse response = new MonthSalaryResponse();
        BeanUtils.copyProperties(monthSalary, response);
        return response;
    }
}
