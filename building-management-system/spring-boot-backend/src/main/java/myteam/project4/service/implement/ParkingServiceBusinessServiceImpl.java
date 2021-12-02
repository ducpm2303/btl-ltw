package myteam.project4.service.implement;

import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.CleanedService;
import myteam.project4.entity.ParkingService;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.ParkingServiceMapper;
import myteam.project4.model.request.ParkingServiceRequest;
import myteam.project4.model.response.ParkingServiceResponse;
import myteam.project4.repository.ServiceRepository;
import myteam.project4.service.ParkingServiceBusinessService;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ParkingServiceBusinessServiceImpl implements ParkingServiceBusinessService {

    private final ServiceRepository serviceRepository;

    private final ParkingServiceMapper parkingServiceMapper;

    public ParkingServiceBusinessServiceImpl(ServiceRepository serviceRepository, ParkingServiceMapper parkingServiceMapper) {
        this.serviceRepository = serviceRepository;
        this.parkingServiceMapper = parkingServiceMapper;
    }

    @Override
    public ParkingServiceResponse getActiveParkingService() {
        ParkingService parkingService = serviceRepository.findParkingServiceByActiveIs(true).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_CURRENT_SERVICE)
        );
        return parkingServiceMapper.to(parkingService);
    }

    @Override
    public ParkingServiceResponse createNewParkingService(ParkingServiceRequest request) {
        if(serviceRepository.findParkingServiceByActiveIs(true).isPresent()) {
            serviceRepository.deactivateAll();
        }
        ParkingService parkingService = serviceRepository.save(parkingServiceMapper.to(request));
        return parkingServiceMapper.to(parkingService);
    }
}
