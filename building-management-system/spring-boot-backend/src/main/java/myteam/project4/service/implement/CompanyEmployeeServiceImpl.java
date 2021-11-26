package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.CompanyEmployee;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.CompanyEmployeeMapper;
import myteam.project4.model.request.CompanyEmployeeRequest;
import myteam.project4.model.response.CompanyEmployeeResponse;
import myteam.project4.repository.CompanyEmployeeRepository;
import myteam.project4.service.CompanyEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class CompanyEmployeeServiceImpl implements CompanyEmployeeService {

    private final CompanyEmployeeRepository repository;
    private final CompanyEmployeeMapper mapper;

    @Override
    public CompanyEmployeeResponse save(CompanyEmployeeRequest request) {
        CompanyEmployee companyEmployee = mapper.to(request);
        return mapper.to(repository.saveAndFlush(companyEmployee));
    }

    @Override
    public CompanyEmployeeResponse updateById(Long id, CompanyEmployeeRequest request) {
        CompanyEmployee companyEmployee = mapper.to(request);
        repository.updateById(id,
                companyEmployee.getCode(),
                companyEmployee.getDateOfBirth(),
                companyEmployee.getIdentification(),
                companyEmployee.getName(),
                companyEmployee.getPhone(),
                companyEmployee.getCompany().getId()
        );
        companyEmployee.setId(id);
        return mapper.to(companyEmployee);
    }

    @Override
    public CompanyEmployeeResponse findById(Long id) {
        CompanyEmployee companyEmployee = repository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_COMPANY_EMPLOYEE)
        );
        return mapper.to(companyEmployee);
    }

    @Override
    public String deleteById(Long id) {
        CompanyEmployee companyEmployee = repository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_COMPANY_EMPLOYEE)
        );
        repository.delete(companyEmployee);
        return "Deleted";
    }

    @Override
    public List<CompanyEmployeeResponse> getAllCompanyEmployee() {
        List<CompanyEmployee> list = repository.findAll();
        return list.stream().map(mapper::to).collect(Collectors.toList());
    }

    @Override
    public List<CompanyEmployeeResponse> findByCompanyId(Long company_id) {
        List<CompanyEmployee> list = repository.findByCompanyId(company_id);
        return list.stream().map(mapper::to).collect(Collectors.toList());
    }
}
