import axios from "axios";
const COMPANY_API_URL = "http://localhost:8080/public-api/v1.0.0/company"

class CompanyService{

    getAllCompany(){
        return axios.get(COMPANY_API_URL + '/list');
    }
}

export default new CompanyService();