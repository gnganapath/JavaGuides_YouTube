import React, { useState, useEffect } from "react";
import { useHistory } from 'react-router-dom';
import EmployeeService from "../services/EmployeeService";

// method 2 - define functional component - Define with function and default export at the bottom of component
function UpdateEmployee(){
    const [employeeId, setEmployeeId] = useState("");
    const history = useHistory();

    function  getEmployeeById(){
        console.log('call the -api/v1/employees/{id}',employeeId)
        EmployeeService.updateEmployee('1', {}).then( Status =>{
            console.log('Status');
            setEmployeeId(Status.data)
        })
    }


    useEffect(()=>{
        //DOM mounted call the API to diplay selected employee by Id 
        //Class based component life  cylce method is ComponentDidMount() is equlent to useEffect() { methods , []}
        getEmployeeById();
    },[])

   function backToList(){
       // path = "/" also navigate to the home page or Employee list component is configured in app.js
       history.push('/');  
   }
    return (
        <div>
        <h2> Update Employee </h2>
        <div className="row"><button className="btn btn-warning" onClick={backToList}>Go to List</button></div>
        </div>
    )
}
export default UpdateEmployee;