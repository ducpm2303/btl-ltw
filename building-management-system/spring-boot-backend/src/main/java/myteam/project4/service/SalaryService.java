package myteam.project4.service;

import myteam.project4.entity.Salary;
import myteam.project4.model.request.BuildingEmployeeRequest;
import myteam.project4.model.request.SalaryRequest;
import myteam.project4.model.response.BuildingEmployeeResponse;
import myteam.project4.model.response.SalaryResponse;

import java.util.List;

public interface SalaryService {

    SalaryResponse save(SalaryRequest salaryRequest);
    SalaryResponse save(Long id, SalaryRequest salaryRequest);
    SalaryResponse findById(Long id);
    String deleteById(Long id);
    List<SalaryResponse> getAllSalary();
    List<SalaryResponse> findSalaryByPositionLike(String position);
}
