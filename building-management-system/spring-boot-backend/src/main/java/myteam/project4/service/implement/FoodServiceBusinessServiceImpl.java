package myteam.project4.service.implement;

import lombok.extern.log4j.Log4j2;
import myteam.project4.entity.FoodService;
import myteam.project4.entity.ParkingService;
import myteam.project4.exception.BusinessCode;
import myteam.project4.exception.BusinessException;
import myteam.project4.mapper.FoodServiceMapper;
import myteam.project4.model.request.FoodServiceRequest;
import myteam.project4.model.response.FoodServiceResponse;
import myteam.project4.repository.ServiceRepository;
import myteam.project4.service.FoodServiceBusinessService;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class FoodServiceBusinessServiceImpl implements FoodServiceBusinessService {

    private final ServiceRepository serviceRepository;

    private final FoodServiceMapper foodServiceMapper;

    public FoodServiceBusinessServiceImpl(ServiceRepository serviceRepository, FoodServiceMapper foodServiceMapper) {
        this.serviceRepository = serviceRepository;
        this.foodServiceMapper = foodServiceMapper;
    }

    @Override
    public FoodServiceResponse getActiveFoodService() {
        FoodService foodService = serviceRepository.findFoodServiceByActiveIs(true).orElseThrow(
                () -> new BusinessException(BusinessCode.NOT_FOUND_CURRENT_SERVICE)
        );
        return foodServiceMapper.to(foodService);
    }

    @Override
    public FoodServiceResponse createNewFoodService(FoodServiceRequest request) {
        if(serviceRepository.findFoodServiceByActiveIs(true).isPresent()) {
            serviceRepository.deactivateAll();
        }
        FoodService foodService = serviceRepository.save(foodServiceMapper.to(request));
        return foodServiceMapper.to(foodService);
    }
}
