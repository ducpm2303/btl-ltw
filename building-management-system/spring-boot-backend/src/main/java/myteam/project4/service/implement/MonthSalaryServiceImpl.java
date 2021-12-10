package myteam.project4.service.implement;

import myteam.project4.entity.BuildingEmployee;
import myteam.project4.mapper.BuildingEmployeeMapper;
import myteam.project4.mapper.MonthSalaryMapper;
import myteam.project4.model.request.MonthRequest;
import myteam.project4.model.response.BuildingEmployeeResponse;
import myteam.project4.repository.BuildingEmployeeRepository;
import myteam.project4.repository.MonthSalaryRepository;
import myteam.project4.service.MonthSalaryService;

import java.util.List;
import java.util.stream.Collectors;

public class MonthSalaryServiceImpl implements MonthSalaryService {

    private final MonthSalaryRepository monthSalaryRepository;
    private final MonthSalaryMapper monthSalaryMappermapper;

    private final BuildingEmployeeRepository repository;
    private final BuildingEmployeeMapper mapper;

    public MonthSalaryServiceImpl(MonthSalaryRepository monthSalaryRepository, MonthSalaryMapper mapper, BuildingEmployeeRepository repository, BuildingEmployeeMapper mapper1) {
        this.monthSalaryRepository = monthSalaryRepository;
        this.monthSalaryMappermapper = mapper;
        this.repository = repository;
        this.mapper = mapper1;
    }

    @Override
    public List<BuildingEmployeeResponse> getAllMonthSalaryPrecent(boolean isDeleted) {
        List<BuildingEmployee> list = repository.findActive(false);
        return list.stream().map(mapper::to).collect(Collectors.toList());
    }

    @Override
    public List<BuildingEmployeeResponse> getMonthSalaryByMonth(MonthRequest request) {
        return null;
    }
}
