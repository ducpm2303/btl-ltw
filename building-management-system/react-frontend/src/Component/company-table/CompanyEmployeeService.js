import axios from "axios";
const COMPANYEMPLOYEE_API_URL = "http://localhost:8080/public-api/v1.0.0/company_employee"

class CompanyEmployeeService{

    getAllCompanyEmployee(){
        return axios.get(COMPANYEMPLOYEE_API_URL + '/list');
    }

    createCompanyEmployee(companyEmployee){
        return axios.post(COMPANYEMPLOYEE_API_URL + '/create', companyEmployee)
    }

    updateCompanyEmployee(id, companyEmployee){
        return axios.put(COMPANYEMPLOYEE_API_URL + '/update/' + id, companyEmployee)
    }

    deleteCompanyEmployee(id){
        return axios.delete(COMPANYEMPLOYEE_API_URL + '/delete/' + id)
    }

    getEmployeeByCompanyId(companyId){
        return axios.get(COMPANYEMPLOYEE_API_URL + '/company/' + companyId);
    }

    searchByName(name, companyId){
        return axios.get(COMPANYEMPLOYEE_API_URL + '/search?name='+ name + '&company_id='+ companyId);
    }


}

export default new CompanyEmployeeService();
