package myteam.project4.service.implement;

import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.ParkingService;
import myteam.project4.entity.ProtectedService;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.ProtectedServiceMapper;
import myteam.project4.model.request.ProtectedServiceRequest;
import myteam.project4.model.response.ProtectedServiceResponse;
import myteam.project4.repository.ServiceRepository;
import myteam.project4.service.ProtectedServiceBusinessService;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProtectedServiceBusinessServiceImpl implements ProtectedServiceBusinessService {

    private final ServiceRepository serviceRepository;
    private final ProtectedServiceMapper protectedServiceMapper;

    public ProtectedServiceBusinessServiceImpl(ServiceRepository serviceRepository, ProtectedServiceMapper protectedServiceMapper) {
        this.serviceRepository = serviceRepository;
        this.protectedServiceMapper = protectedServiceMapper;
    }

    @Override
    public ProtectedServiceResponse getActiveProtectedService() {
        ProtectedService protectedService = serviceRepository.findProtectedServiceByActiveIs(true).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_CURRENT_SERVICE)
        );
        return protectedServiceMapper.to(protectedService);
    }

    @Override
    public ProtectedServiceResponse createNewProtectedService(ProtectedServiceRequest request) {
        if(serviceRepository.findProtectedServiceByActiveIs(true).isPresent()) {
            serviceRepository.deactivateAll();
        }
        ProtectedService protectedService = serviceRepository.save(protectedServiceMapper.to(request));
        return protectedServiceMapper.to(protectedService);
    }
}
