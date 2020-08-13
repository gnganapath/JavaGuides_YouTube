import React, { useState, useEffect } from "react";
import EmployeeService from "../services/EmployeeService";
//import axios from "axios";
import { useHistory } from 'react-router-dom';
import UpdateEmployee from "./UpdateEmployee";

// method 1 - define functional component

export default function ListEmployeeComponent() {
  const [employees, setEmployees] = useState([]);
  const history = useHistory();
  /*
    async function getEmployees(){
        const response = await fetch('http://localhost:8080/api/v1/employee');
        const json = await response.json();
        console.log(json)
        setEmployees(json)
    }
    useEffect( ()=>{
        getEmployees();
    },[])
    */
  function getEmployeesFromServcieAxios() {
    EmployeeService.getEmployees().then((res) => {
        console.log(res.data)
      setEmployees(res.data);
    });
    // Simple way to call the axios service 
    // axios.get("http://localhost:8080/api/v1/employee").then((res) => {
    //   setEmployees(res.data);
    // });
  }
  useEffect(() => {
    //onLoad -ngOnInit() in angualr call the rest API to display the 
    getEmployeesFromServcieAxios();
  }, []);

  function navigateToAddEmployee(){
    history.push('/add-employee');
  }

  function UpdateEmployee(empId){
    history.push('/update-employee/'+empId);
    // this.state.history.push('update-employee/'+${empId})  // no need to import useHistory hooks
  }

  function DeleteEmployee(deleteID){
    EmployeeService.deleteEmployee(deleteID).then((response) =>{
      console.log(response);
      
      setEmployees(employees.filter(employee => employee.id !== deleteID));
    });

  
  }

  return (
    <div>
      <h2 className="text-center">Employee List</h2>
      <div className="row">
      <button className="btn btn-primary" onClick={navigateToAddEmployee}>Add Employee</button>
      </div>
      <div className="row">         
        <table className="table table-stripped table-bordered">
          <thead>
            <tr>
              <th>Employee</th>
              <th>Job Role</th>
              <th>Email</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.fullName}</td>
                <td>{employee.jobRole}</td>
                <td>{employee.emailId}</td>
                <td> 
                    <button onClick={ () => UpdateEmployee(employee.id) } className="btn btn-info">Update</button>
                    <button onClick={ () => DeleteEmployee(employee.id) } className="btn btn-info">Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
