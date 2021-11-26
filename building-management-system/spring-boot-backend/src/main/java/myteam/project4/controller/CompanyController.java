package myteam.project4.controller;

import lombok.AllArgsConstructor;
import myteam.project4.model.request.CompanyRequest;
import myteam.project4.model.response.BaseResponse;
import myteam.project4.model.response.CompanyDetailResponse;
import myteam.project4.model.response.CompanyResponse;
import myteam.project4.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("public-api/v1.0.0/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("{id}")
    BaseResponse<CompanyDetailResponse> getCompanyById(@PathVariable Long id){
        return BaseResponse.ofSuccess(companyService.findById(id));
    }

    @GetMapping("/list")
    BaseResponse<List<CompanyResponse>> getAllCompany(){
        return BaseResponse.ofSuccess(companyService.getAllCompany());
    }

    @PutMapping("/update/{id}")
    BaseResponse<CompanyResponse> updateCompany(@PathVariable Long id, @RequestBody CompanyRequest request){
        return BaseResponse.ofSuccess(companyService.updateById(id,request));
    }

    @PostMapping("/create")
    BaseResponse<CompanyResponse> createCompany(@RequestBody CompanyRequest request){
        return BaseResponse.ofSuccess(companyService.save(request));
    }

    @DeleteMapping("/delete/{id}")
    BaseResponse<String> deleteCompany(@PathVariable Long id){
        return BaseResponse.ofSuccess(companyService.deleteById(id));
    }


}
