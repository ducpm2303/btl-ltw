package myteam.project4.mapper;

import lombok.AllArgsConstructor;
import myteam.project4.entity.Company;
import myteam.project4.entity.CompanyEmployee;
import myteam.project4.model.request.CompanyRequest;
import myteam.project4.model.response.CompanyDetailResponse;
import myteam.project4.model.response.CompanyEmployeeResponse;
import myteam.project4.model.response.CompanyResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CompanyMapper implements Mapper<Company> {
    private final CompanyEmployeeMapper companyEmployeeMapper;

    public Company to(CompanyRequest request){
        Company company = new Company();
        BeanUtils.copyProperties(request,company);
        return company;
    }

    public CompanyResponse to(Company company){
        CompanyResponse companyResponse = new CompanyResponse();
        BeanUtils.copyProperties(company,companyResponse);
        if(company.getCompanyEmployeeList() != null){
            Long numberOfEmployee = Long.valueOf(company.getCompanyEmployeeList().size());
            companyResponse.setNumberOfEmployee(Long.valueOf(company.getCompanyEmployeeList().size()));
        }
        return companyResponse;
    }

    public CompanyDetailResponse toDetail(Company company){
        CompanyDetailResponse companyDetailResponse = new CompanyDetailResponse();
        BeanUtils.copyProperties(company,companyDetailResponse);
        if(company.getCompanyEmployeeList() != null){
            List<CompanyEmployeeResponse> companyEmployeeResponseList = companyEmployeeMapper.toList(company.getCompanyEmployeeList(),companyEmployeeMapper::to);
            companyDetailResponse.setCompanyEmployeeList(companyEmployeeResponseList);
        }
//        if(company.getUsedServiceList() != null)
        return companyDetailResponse;
    }
}
