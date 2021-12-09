package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.Company;
import myteam.project4.entity.CompanyEmployee;
import myteam.project4.entity.UsedService;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.CompanyEmployeeMapper;
import myteam.project4.mapper.CompanyMapper;
import myteam.project4.mapper.UsedServiceMapper;
import myteam.project4.model.request.CompanyRequest;
import myteam.project4.model.response.CompanyDetailResponse;
import myteam.project4.model.response.CompanyResponse;
import myteam.project4.repository.CompanyEmployeeRepository;
import myteam.project4.repository.CompanyRepository;
import myteam.project4.repository.ServiceRepository;
import myteam.project4.repository.UsedServiceRepository;
import myteam.project4.service.CompanyService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyEmployeeRepository companyEmployeeRepository;
    private final UsedServiceRepository usedServiceRepository;
    private final ServiceRepository serviceRepository;

    private final CompanyMapper companyMapper;
    private final UsedServiceMapper usedServiceMapper;
    private final CompanyEmployeeMapper companyEmployeeMapper;

    @Override
    public CompanyResponse save(CompanyRequest request) {
        Company company = companyRepository.saveAndFlush(companyMapper.to(request));
        serviceRequired(company);
        return companyMapper.to(company);
    }

    @Override
    public CompanyResponse updateById(Long id, CompanyRequest request) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_COMPANY)
        );
        return companyMapper.to(companyRepository.saveAndFlush(companyMapper.to(company,request)));
    }

    @Override
    public CompanyDetailResponse findById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_COMPANY)
        );
        Long currentMonth = Long.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
        List<UsedService> usedServiceList = usedServiceRepository.findUsedServiceMonthByCompanyId(id,currentMonth);
        List<CompanyEmployee> companyEmployeeList = companyEmployeeRepository.findCompanyEmployeeByIsDeletedAndCompanyId(false,id);
        company.setCompanyEmployeeList(companyEmployeeList);
        company.setUsedServiceList(usedServiceList);

        return companyMapper.toDetail(company);
    }

    @Override
    public String deleteById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_COMPANY)
        );
        company.setIsDeleted(true);
        companyRepository.saveAndFlush(company);
        List<CompanyEmployee> companyEmployeeList = companyEmployeeRepository.findCompanyEmployeeByIsDeletedAndCompanyId(false,company.getId());
        List<UsedService> usedServiceList = usedServiceRepository.findByIsDeletedAndCompanyId(false,company.getId());
        for(CompanyEmployee companyEmployee: companyEmployeeList){
            companyEmployee.setIsDeleted(true);
            companyEmployeeRepository.saveAndFlush(companyEmployee);
        }
        for(UsedService usedService: usedServiceList){
            usedService.setIsDeleted(true);
            usedServiceRepository.saveAndFlush(usedService);
        }
        return "Deleted";
    }

    @Override
    public List<CompanyResponse> getAllCompany() {
        List<Company> companyList = companyRepository.findAllByIsDeleted(false);
        return companyList.stream().map(companyMapper::to).collect(Collectors.toList());
    }

    @Override
    public List<CompanyResponse> findCompanyByNameLike(String name) {
        String searchName= "%"+name+"%";
        List<Company> companyList = companyRepository.findCompanyByIsDeletedAndNameLike(false, searchName);
        return companyList.stream().map(companyMapper::to).collect(Collectors.toList());
    }


    private void serviceRequired(Company company){
        UsedService usedService = new UsedService();
        usedService.setCompany(company);
        usedService.setStartDate(new Timestamp(System.currentTimeMillis()));
        myteam.project4.entity.Service service = serviceRepository.findCleanedServiceByActiveIs(true).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_CURRENT_SERVICE)
        );
        usedService.setService(service);
        usedServiceRepository.saveAndFlush(usedService);

        usedService = new UsedService();
        usedService.setCompany(company);
        usedService.setStartDate(new Timestamp(System.currentTimeMillis()));
        service = serviceRepository.findProtectedServiceByActiveIs(true).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_CURRENT_SERVICE)
        );
        usedService.setService(service);
        usedServiceRepository.saveAndFlush(usedService);
    }
}
