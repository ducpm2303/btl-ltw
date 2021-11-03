package myteam.project4.controller;

import myteam.project4.model.request.CompanyEmployeeRequest;
import myteam.project4.model.response.BaseResponse;
import myteam.project4.model.response.CompanyEmployeeResponse;
import myteam.project4.service.CompanyEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public-api/v1.0.0/company_employee")
public class CompanyEmployeeController {
    private final CompanyEmployeeService companyEmployeeService;

    public CompanyEmployeeController(CompanyEmployeeService companyEmployeeService) {
        this.companyEmployeeService = companyEmployeeService;
    }

    @PostMapping
    public BaseResponse<CompanyEmployeeResponse> createCompanyEmployee(@RequestBody CompanyEmployeeRequest request){
        return BaseResponse.ofSuccess(companyEmployeeService.save(request));
    }

    @PutMapping("update/{id}")
    public BaseResponse<CompanyEmployeeResponse> updateCompanyEmployeeById(@PathVariable Long id, @RequestBody CompanyEmployeeRequest request){
        return BaseResponse.ofSuccess(companyEmployeeService.updateById(id,request));
    }

    @GetMapping("{id}")
    public  BaseResponse<CompanyEmployeeResponse> getCompanyEmployeeById(@PathVariable Long id){
        return BaseResponse.ofSuccess(companyEmployeeService.findById(id));
    }

    @GetMapping("/list")
    public BaseResponse<List<CompanyEmployeeResponse>> getAllCompanyEmployee(){
        return BaseResponse.ofSuccess(companyEmployeeService.getAllCompanyEmployee());
    }

    @DeleteMapping("delete/{id}")
    public BaseResponse<String> deleteCompanyEmployeeById(@PathVariable Long id){
        return BaseResponse.ofSuccess((companyEmployeeService.deleteById(id)));
    }

}
