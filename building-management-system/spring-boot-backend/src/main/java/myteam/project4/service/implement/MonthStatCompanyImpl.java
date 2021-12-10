package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import myteam.project4.entity.Company;
import myteam.project4.mapper.CompanyMapper;
import myteam.project4.model.request.MonthRequest;
import myteam.project4.model.response.MonthStatCompanyResponse;
import myteam.project4.repository.CompanyRepository;
import myteam.project4.service.MonthStatCompany;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MonthStatCompanyImpl implements MonthStatCompany {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<MonthStatCompanyResponse> viewStatistic(MonthRequest request) {
        List<MonthStatCompanyResponse> monthStatCompanyResponses = new ArrayList<>();
        List<Company> companyList = companyRepository.findAllByIsDeleted(false);
        for (Company company: companyList) {
            MonthStatCompanyResponse response = new MonthStatCompanyResponse();
            response.setCompanyResponse(companyMapper.to(company));
            //code tiếp
        }
        return monthStatCompanyResponses;
    }
}
