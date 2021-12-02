package myteam.project4.service.implement;

import lombok.AllArgsConstructor;
import lombok.Data;
import myteam.project4.entity.CleanedService;
import myteam.project4.entity.MaintenanceService;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.CleanedServiceMapper;
import myteam.project4.mapper.MaintenanceMapper;
import myteam.project4.model.request.CleanedRequest;
import myteam.project4.model.request.MaintenanceRequest;
import myteam.project4.model.response.CleanedResponse;
import myteam.project4.model.response.MaintenanceResponse;
import myteam.project4.repository.ServiceRepository;
import myteam.project4.service.MaintenanceBusinessService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessServiceImpl implements MaintenanceBusinessService {

    private final ServiceRepository serviceRepository;

    private final MaintenanceMapper maintenanceMapper;

    @Override
    public MaintenanceResponse getActiveMaintenanceService() {
        MaintenanceService maintenanceService = serviceRepository.findMaintenanceServiceByActiveIs(true).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_CURRENT_SERVICE)
        );
        return maintenanceMapper.to(maintenanceService);
    }

    @Override
    public MaintenanceResponse createNewMaintenanceService(MaintenanceRequest request) {
        if(serviceRepository.findCleanedServiceByActiveIs(true).isPresent()) {
            serviceRepository.deactivateAllMaintenanceService();
        }
        MaintenanceService maintenanceService = serviceRepository.save(maintenanceMapper.to(request));
        return maintenanceMapper.to(maintenanceService);
    }
}
