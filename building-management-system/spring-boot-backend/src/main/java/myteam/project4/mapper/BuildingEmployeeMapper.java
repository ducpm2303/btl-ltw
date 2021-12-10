package myteam.project4.mapper;

import lombok.AllArgsConstructor;
import myteam.project4.entity.BuildingEmployee;
import myteam.project4.entity.MonthSalary;
import myteam.project4.entity.Salary;
import myteam.project4.model.request.BuildingEmployeeRequest;
import myteam.project4.model.request.MonthRequest;
import myteam.project4.model.response.BuildingEmployeeResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BuildingEmployeeMapper implements Mapper<BuildingEmployee> {

    private final SalaryMapper salaryMapper;

    private Timestamp convertStringToTimestamp(String dateOfBirth) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dateOfBirth + " 00:00:00"));
        return Timestamp.valueOf(localDateTime);
    }

    private String convertTimestampToString(Timestamp dateOfBirth) {
        return dateOfBirth.toString().split(" ")[0];
    }

    public BuildingEmployee to( BuildingEmployee buildingEmployee ,BuildingEmployeeRequest request) {
        BeanUtils.copyProperties(request, buildingEmployee);
        buildingEmployee.setDateOfBirth(convertStringToTimestamp(request.getDateOfBirth()));
        return buildingEmployee;
    }

    public BuildingEmployeeResponse to(BuildingEmployee buildingEmployee) {
        BuildingEmployeeResponse response = new BuildingEmployeeResponse();
        BeanUtils.copyProperties(buildingEmployee, response);
        response.setDateOfBirth(convertTimestampToString(buildingEmployee.getDateOfBirth()));
        List<MonthSalary> monthSalaryList = buildingEmployee.getMonthSalaryList();
        Salary salary = new Salary();
        for (MonthSalary m: monthSalaryList) {
            if (!m.getIsDeleted()) {
                salary = m.getSalary();
            }
        }
        response.setSalaryResponse(salaryMapper.to(salary));
        return response;
    }

    public BuildingEmployeeResponse toByMonth(BuildingEmployee buildingEmployee, MonthRequest request) {
        BuildingEmployeeResponse response = new BuildingEmployeeResponse();
        BeanUtils.copyProperties(buildingEmployee, response);
        response.setDateOfBirth(convertTimestampToString(buildingEmployee.getDateOfBirth()));
        List<MonthSalary> monthSalaryList = buildingEmployee.getMonthSalaryList();
        Salary salary = new Salary();
        String time = "";
        if ( request.getMonth() < 10 ) {
            time = request.getYear()+ "-0" +request.getMonth() + "-01";
        } else {
            time = request.getYear()+ "-" +request.getMonth() + "-01";
        }
        Timestamp current = new Timestamp(System.currentTimeMillis());
        Timestamp compare = convertStringToTimestamp(time);
        if ( compare.after(current) ) {
            return new BuildingEmployeeResponse();
        }
        for (MonthSalary m: monthSalaryList) {
            if (m.getCreatedAt().before(compare)) {
                salary = m.getSalary();
            }
        }
        response.setSalaryResponse(salaryMapper.to(salary));
        return response;
    }

}
