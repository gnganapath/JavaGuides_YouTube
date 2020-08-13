import React, { useState } from "react";
import { useHistory } from 'react-router-dom';
import EmployeeService from "../services/EmployeeService";

const AddEmployee = () => {
  const [name, setName] = useState("");
  const [jobRole, setJobRole] = useState("");
  const [email, setEmail] = useState("");
  const history = useHistory();

  // handleNameChange
  function handleNameChange(e) {
    setName(e.target.value);
  }

  function handleJobRoleChange(e) {
    setJobRole(e.target.value);
  }

  function handleEmailChange(e) {
    setEmail(e.target.value);
  }

  function saveOrUpdateEmployee(e) {
      e.preventDefault();
    let addEmployee = {
      fullName: name,
      jobRole: jobRole,
      emailId: email,
    };
    console.log(addEmployee);
    EmployeeService.createEmployee(addEmployee).then( res =>{
        //after submit clear the form and stay in the same page. just practise purpose
        setName('');   setJobRole('');   setEmail('');
        // usual way to nagivate to employee list and show added / updated list of employee calling navigation -> cancel() no need of this.cancel. i.e functional component
        //cancel();
    })
  }

  function cancel(){
    history.push('/employees');
    }
  // useEffect( () =>{

  // },[])
  return (
    <div>
       
     <h2> Add employee</h2> 
      
      <form onSubmit={saveOrUpdateEmployee}>
        <div className="form-group">
          <label> Full Name: </label>
          <input placeholder="Full Name" name="fullName" className="form-control" value={name} type="text" onChange={handleNameChange}
          />
        </div>

        <div className="form-group">
          <label> Job Role:</label>
          <select     value={jobRole}    onChange={handleJobRoleChange}   className="form-control"  >
            <option value=""></option>
            <option value="Developer">Developer</option>
            <option value="Architect">Architect</option>
            <option value="Project Lead">Project Lead</option>
          </select>         
        </div>

        <div className="form-group">
          <label> Email : </label>
          <input placeholder="Email" name="emailId"  className="form-control" value={email} type="text" onChange={handleEmailChange}    />
        </div>
         <input type="submit" className="btn btn-primary" value="submit"></input>
      
        <button className="btn btn-danger" onClick={cancel} style={{ marginLeft: "10px" }}
        >
          Cancel
        </button>
      </form>
      <div className="row">---</div> <div className="row">***</div>
      <div className="row col-md-12 ">
         <button onClick={cancel} className="btn btn-warning pull-right">Back to list</button>
      </div>
    </div>
  );
};
export default AddEmployee;
