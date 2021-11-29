package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.Company;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.CompanyMapper;
import myteam.project4.model.request.CompanyRequest;
import myteam.project4.model.response.CompanyDetailResponse;
import myteam.project4.model.response.CompanyResponse;
import myteam.project4.repository.CompanyRepository;
import myteam.project4.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse save(CompanyRequest request) {
        Company company = companyMapper.to(request);
        return companyMapper.to(companyRepository.saveAndFlush(company));
    }

    @Override
    public CompanyResponse updateById(Long id, CompanyRequest request) {
        Company company = companyMapper.to(request);
        companyRepository.updateById(
                company.getId(),
                company.getTaxCode(),
                company.getAuthorizedCapital(),
                company.getFieldOfActivity(),
                company.getFloor(),
                company.getHotline(),
                company.getName(),
                company.getArea()
        );
        company.setId(id);
        return companyMapper.to(company);
    }

    @Override
    public CompanyDetailResponse findById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_COMPANY)
        );
        return companyMapper.toDetail(company);
    }

    @Override
    public String deleteById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_COMPANY)
        );
        companyRepository.delete(company);
        return "Deleted";
    }

    @Override
    public List<CompanyResponse> getAllCompany() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream().map(companyMapper::to).collect(Collectors.toList());
    }
}
