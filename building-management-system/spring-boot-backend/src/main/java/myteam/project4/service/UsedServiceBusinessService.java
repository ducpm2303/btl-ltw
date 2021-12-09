package myteam.project4.service;

import myteam.project4.model.request.UsedServiceRequest;
import myteam.project4.model.response.UsedServiceResponse;

import java.util.List;

public interface UsedServiceBusinessService {

    UsedServiceResponse save(UsedServiceRequest request);

    List<UsedServiceResponse> findUsedServiceMonthByCompany(Long companyId, Long month);
}