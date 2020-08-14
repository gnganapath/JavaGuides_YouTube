import React, { useState, useEffect } from "react";
import { useHistory } from 'react-router-dom';
import EmployeeService from "../services/EmployeeService";
import {withRouter, RouteComponentProps} from "react-router";
// method 2 - define functional component - Define with function and default export at the bottom of component
function UpdateEmployee(props: MyComponentProps){
    const [employeeId, setEmployeeId] = useState("");
    const history = useHistory();
    
    function  getEmployeeById(){
        //console.log(employeeId,props)
       // setEmployeeId(props.match.params.id);  // not Working
        let empId = props.match.params.id;   // Working to detect url params - i.e employeeID
       // setEmployeeId(empId);  // not Working
        console.log('call the -api/v1/employees/{id}',employeeId)
        EmployeeService.getEmployeesById(empId).then( Status =>{
            console.log(Status, employeeId);
            //setEmployeeId(Status.data)
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

interface MyComponentProps extends RouteComponentProps {
    myField: string;
}

export default withRouter(UpdateEmployee);