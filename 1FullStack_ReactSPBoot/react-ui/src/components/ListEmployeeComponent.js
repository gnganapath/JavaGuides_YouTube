import React, { useState, useEffect } from "react";
import EmployeeService from "../services/EmployeeService";
import axios from "axios";

export default function ListEmployeeComponent() {
  const [employees, setEmployees] = useState([]);

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
    // axios.get("http://localhost:8080/api/v1/employee").then((res) => {
    //   setEmployees(res.data);
    // });
  }
  useEffect(() => {
    getEmployeesFromServcieAxios();
  }, []);

  return (
    <div>
      <h2 className="text-center">Employee List</h2>
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
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
