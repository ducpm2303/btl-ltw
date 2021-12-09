package myteam.project4.controller;

import lombok.AllArgsConstructor;
import myteam.project4.model.request.CompanyEmployeeRequest;
import myteam.project4.model.response.BaseResponse;
import myteam.project4.model.response.CompanyEmployeeResponse;
import myteam.project4.model.response.CompanyResponse;
import myteam.project4.service.CompanyEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("public-api/v1.0.0/company_employee")
public class CompanyEmployeeController {
    private final CompanyEmployeeService companyEmployeeService;


    @PostMapping("create")
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

    @GetMapping("/company/{company_id}")
    public BaseResponse<List<CompanyEmployeeResponse>> getCompanyEmployeeByCompanyId(@PathVariable Long company_id){
        return BaseResponse.ofSuccess(companyEmployeeService.findByIsDeletedAndCompanyId(false, company_id));
    }

    @GetMapping("/list")
    public BaseResponse<List<CompanyEmployeeResponse>> getAllCompanyEmployee(){
        return BaseResponse.ofSuccess(companyEmployeeService.getAllCompanyEmployee());
    }

    @DeleteMapping("delete/{id}")
    public BaseResponse<String> deleteCompanyEmployeeById(@PathVariable Long id){
        return BaseResponse.ofSuccess((companyEmployeeService.deleteById(id)));
    }

    @GetMapping("/search")
    BaseResponse<List<CompanyEmployeeResponse>> findCompanyEmployeeByNameLike(@RequestParam String name, @RequestParam Long company_id){
        return BaseResponse.ofSuccess(companyEmployeeService.findCompanyEmployeeByNameLike(name, company_id));
    }

}
