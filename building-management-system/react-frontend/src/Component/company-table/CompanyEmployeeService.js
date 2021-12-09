import axios from "axios";
const COMPANYEMPLOYEE_API_URL = "http://localhost:8080/public-api/v1.0.0/company/"

class CompanyEmployeeService{

    createCompanyEmployee(companyId, companyEmployee){
        return axios.post(COMPANYEMPLOYEE_API_URL + companyId + '/employee/create', companyEmployee)
    }

    updateCompanyEmployee(companyId, id, companyEmployee){
        return axios.put(COMPANYEMPLOYEE_API_URL + companyId + '/employee/update/' + id, companyEmployee)
    }

    deleteCompanyEmployee(companyId, id){
        return axios.delete(COMPANYEMPLOYEE_API_URL + companyId + '/employee/delete/' + id)
    }

    getEmployeeByCompanyId(companyId){
        return axios.get(COMPANYEMPLOYEE_API_URL  + companyId + '/employee');
    }

    searchByName(name, companyId){
        return axios.get(COMPANYEMPLOYEE_API_URL + companyId + '/employee/search?name='+ name);
    }


}

export default new CompanyEmployeeService();
