package myteam.project4.controller;

import lombok.AllArgsConstructor;
import myteam.project4.model.request.CompanyEmployeeRequest;
import myteam.project4.model.request.CompanyRequest;
import myteam.project4.model.request.UsedServiceRequest;
import myteam.project4.model.response.*;
import myteam.project4.service.CompanyEmployeeService;
import myteam.project4.service.CompanyService;
import myteam.project4.service.UsedServiceBusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("public-api/v1.0.0/company")
public class CompanyController {

    private final CompanyService companyService;
    private final UsedServiceBusinessService usedService;
    private final CompanyEmployeeService companyEmployeeService;

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

    @GetMapping("/search")
    BaseResponse<List<CompanyResponse>> findCompanyByNameLike(@RequestParam String name){
        return BaseResponse.ofSuccess(companyService.findCompanyByNameLike(name));
    }

    @PostMapping("/{company_id}/add-service/{service_id}")
    BaseResponse<UsedServiceResponse> createUsedService(@PathVariable Long company_id, @PathVariable Long service_id){
        UsedServiceRequest request = new UsedServiceRequest(company_id,service_id);
        return BaseResponse.ofSuccess(usedService.save(request));
    }


    @GetMapping("/{company_id}/used-service/month/{month}")
    BaseResponse<List<UsedServiceResponse>> listUsedServiceMonth(@PathVariable Long company_id, @PathVariable Long month){
        return BaseResponse.ofSuccess(usedService.findUsedServiceMonthByCompany(company_id,month));
    }

    @PostMapping("/{company_id}/employee/create")
    public BaseResponse<CompanyEmployeeResponse> createCompanyEmployee(@PathVariable Long company_id, @RequestBody CompanyEmployeeRequest request){
        request.setCompany_id(company_id);
        return BaseResponse.ofSuccess(companyEmployeeService.save(request));
    }

    @PutMapping("/{company_id}/employee/update/{employee_id}")
    public BaseResponse<CompanyEmployeeResponse> updateCompanyEmployeeById(@PathVariable Long company_id,@PathVariable Long employee_id,@RequestBody CompanyEmployeeRequest request){
        request.setCompany_id(company_id);
        return BaseResponse.ofSuccess(companyEmployeeService.updateById(employee_id,request));
    }

    @GetMapping("/{company_id}/employee/{employee_id}")
    public  BaseResponse<CompanyEmployeeResponse> getCompanyEmployeeById(@PathVariable Long employee_id){
        return BaseResponse.ofSuccess(companyEmployeeService.findById(employee_id));
    }

    @GetMapping("/{company_id}/employee")
    public BaseResponse<List<CompanyEmployeeResponse>> getCompanyEmployeeByCompanyId(@PathVariable Long company_id){
        return BaseResponse.ofSuccess(companyEmployeeService.findByCompanyId(company_id));
    }

//    @GetMapping("/{company_id}/employee/list")
//    public BaseResponse<List<CompanyEmployeeResponse>> getAllCompanyEmployee(){
//        return BaseResponse.ofSuccess(companyEmployeeService.getAllCompanyEmployee());
//    }

    @DeleteMapping("/{company_id}/employee/delete/{id}")
    public BaseResponse<String> deleteCompanyEmployeeById(@PathVariable Long id){
        return BaseResponse.ofSuccess((companyEmployeeService.deleteById(id)));
    }

    @GetMapping("/{company_id}/employee/search")
    BaseResponse<List<CompanyEmployeeResponse>> findCompanyEmployeeByNameLike(@PathVariable Long company_id, @RequestParam String name){
        return BaseResponse.ofSuccess(companyEmployeeService.findCompanyEmployeeByCompanyAndNameLike(company_id,name));
    }
}
