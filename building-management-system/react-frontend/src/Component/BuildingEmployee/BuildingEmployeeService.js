import axios from 'axios';

const BUILDING_EMPLOYEE_API_URL = "http://localhost:8080/public-api/v1.0.0/building_employee";

class BuildingEmployeeService{
    
    getAllBuildingEmployee(){
        return axios.get(BUILDING_EMPLOYEE_API_URL + '/list');
    }


}
export default new BuildingEmployeeService();