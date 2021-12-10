package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import myteam.project4.entity.Company;
import myteam.project4.entity.MonthUsedService;
import myteam.project4.mapper.CompanyMapper;
import myteam.project4.model.request.MonthRequest;
import myteam.project4.model.response.MonthStatCompanyResponse;
import myteam.project4.repository.CompanyRepository;
import myteam.project4.repository.MonthUsedServiceRepository;
import myteam.project4.service.MonthStatCompany;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MonthStatCompanyImpl implements MonthStatCompany {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final MonthUsedServiceRepository monthUsedServiceRepository;

    @Override
    public List<MonthStatCompanyResponse> viewStatistic(int month, int year) {
        List<MonthStatCompanyResponse> monthStatCompanyResponses = new ArrayList<>();
        List<Company> companyList = companyRepository.findAllByIsDeleted(false);
        for (Company company: companyList) {
            MonthStatCompanyResponse response = new MonthStatCompanyResponse();
            response.setCompanyResponse(companyMapper.to(company));
            Long companyId = company.getId();
            String time = "";
            if ( month < 10 ) {
                time = year + "-0" + month + "-01";
            } else {
                time = year + "-" + month + "-01";
            }
            Timestamp date = convertStringToTimestamp(time);
            List<MonthUsedService> monthUsedService = monthUsedServiceRepository.findByCompanyIdAndDate(companyId, date);
            if(monthUsedService != null) {

            }
        }
        return monthStatCompanyResponses;
    }

    private Timestamp convertStringToTimestamp(String dateOfBirth) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dateOfBirth + " 00:00:00"));
        return Timestamp.valueOf(localDateTime);
    }

    private String convertTimestampToString(Timestamp dateOfBirth) {
        return dateOfBirth.toString().split(" ")[0];
    }
}
