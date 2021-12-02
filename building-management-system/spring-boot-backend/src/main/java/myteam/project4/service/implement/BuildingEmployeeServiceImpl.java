package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.BuildingEmployee;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.BuildingEmployeeMapper;
import myteam.project4.model.request.BuildingEmployeeRequest;
import myteam.project4.model.response.BuildingEmployeeResponse;
import myteam.project4.repository.BuildingEmployeeRepository;
import myteam.project4.service.BuildingEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class BuildingEmployeeServiceImpl implements BuildingEmployeeService {

    private final BuildingEmployeeMapper mapper;
    private final BuildingEmployeeRepository repository;


    @Override
    public BuildingEmployeeResponse save(BuildingEmployeeRequest buildingEmployeeRequest) {
        BuildingEmployee buildingEmployee = mapper.to(buildingEmployeeRequest);
        return mapper.to(repository.saveAndFlush(buildingEmployee));
    }

    @Override
    public BuildingEmployeeResponse save(Long id, BuildingEmployeeRequest buildingEmployeeRequest) {
        BuildingEmployee buildingEmployee = mapper.to(buildingEmployeeRequest);
        buildingEmployee.setId(id);
        repository.save(buildingEmployee);
        return mapper.to(buildingEmployee);
    }

    @Override
    public BuildingEmployeeResponse findById(Long id) {
        BuildingEmployee buildingEmployee = repository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_BUILDING_EMPLOYEE)
        );
        return mapper.to(buildingEmployee);
    }

    @Override
    public String deleteById(Long id) {
        BuildingEmployee buildingEmployee = repository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_BUILDING_EMPLOYEE)
        );
        repository.delete(buildingEmployee);
        return "Deleted";
    }

    @Override
    public List<BuildingEmployeeResponse> getAllBuildingEmployee() {
        List<BuildingEmployee> list = repository.findAll();
        return list.stream().map(mapper::to).collect(Collectors.toList());
    }

    @Override
    public List<BuildingEmployeeResponse> getBuildingEmployeeByName(String name) {
        name = "%"+name+"%";
        List<BuildingEmployee> listBuildingEmployee = repository.findByNameLike(name);
        return listBuildingEmployee.stream().map(mapper::to).collect(Collectors.toList());
    }
}
