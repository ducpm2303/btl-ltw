package myteam.project4.mapper;

import myteam.project4.entity.Building;
import myteam.project4.entity.BuildingEmployee;
import myteam.project4.model.request.BuildingEmployeeRequest;
import myteam.project4.model.response.BuildingEmployeeResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BuildingEmployeeMapper implements Mapper<BuildingEmployee> {
    private Timestamp convertStringToTimestamp(String dateOfBirth) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dateOfBirth + " 00:00:00"));
        return Timestamp.valueOf(localDateTime);
    }

    private String convertTimestampToString(Timestamp dateOfBirth) {
        return dateOfBirth.toString().split(" ")[0];
    }

    public BuildingEmployee to(BuildingEmployeeRequest request) {
        BuildingEmployee buildingEmployee = new BuildingEmployee();
        BeanUtils.copyProperties(request, buildingEmployee);
        Building building = new Building();
        building.setId(request.getBuilding_id());
        buildingEmployee.setBuilding(building);
        buildingEmployee.setDateOfBirth(convertStringToTimestamp(request.getDateOfBirth()));
        return buildingEmployee;
    }

    public BuildingEmployeeResponse to(BuildingEmployee buildingEmployee) {
        BuildingEmployeeResponse response = new BuildingEmployeeResponse();
        BeanUtils.copyProperties(buildingEmployee, response);
        response.setDateOfBirth(convertTimestampToString(buildingEmployee.getDateOfBirth()));
        response.setBuilding_id(buildingEmployee.getBuilding().getId());
        return response;
    }

}
