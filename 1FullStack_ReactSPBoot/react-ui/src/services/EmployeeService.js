import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/employees";

class  EmployeeService
{
    // http GET 
    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL);
    }
    // http POST 
    createEmployee( employee ){
        return axios.post(EMPLOYEE_API_BASE_URL, employee );
    }
    //http GET with url Params in API call
    getEmployeesById(empId){
        return axios.get(EMPLOYEE_API_BASE_URL+'/'+empId);
    }
    // http PUT
    updateEmployee( employeeId, employeeUpdateDetails ){
        return axios.put(EMPLOYEE_API_BASE_URL+'/'+employeeId, employeeUpdateDetails);
    }

    // http DELETE
    deleteEmployee( employeeId ){
        return axios.delete(EMPLOYEE_API_BASE_URL+'/'+employeeId);
    }
}
export default new EmployeeService()