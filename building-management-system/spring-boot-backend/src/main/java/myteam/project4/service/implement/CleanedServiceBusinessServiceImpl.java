package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.CleanedService;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.CleanedServiceMapper;
import myteam.project4.model.request.CleanedRequest;
import myteam.project4.model.response.CleanedResponse;
import myteam.project4.repository.ServiceRepository;
import myteam.project4.service.CleanedServiceBusinessService;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CleanedServiceBusinessServiceImpl implements CleanedServiceBusinessService {

    private final ServiceRepository serviceRepository;

    private final CleanedServiceMapper cleanedServiceMapper;

    @Override
    public CleanedResponse getActiveCleanedService() {
        CleanedService cleanedService = serviceRepository.findCleanedServiceByActiveIs(true).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_CURRENT_SERVICE)
        );
        return cleanedServiceMapper.to(cleanedService);
    }

    @Override
    public CleanedResponse createNewCleanedService(CleanedRequest cleanedRequest) {
        if(serviceRepository.findCleanedServiceByActiveIs(true).isPresent()) {
            serviceRepository.deactivateAll();
        }
        CleanedService cleanedService = serviceRepository.save(cleanedServiceMapper.to(cleanedRequest));
        return cleanedServiceMapper.to(cleanedService);
    }
}
