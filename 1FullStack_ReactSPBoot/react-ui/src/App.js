import React from "react";
import { useParams} from "react-router";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import "./App.css";

import HeaderComponent from "./components/HeaderComponent";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import AddEmployee from "./components/AddEmployee";
import UpdateEmployee from './components/UpdateEmployee';
import FooterComponent from "./components/FooterComponent";

function App() {
 
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
        <Switch>
          <Route path="/" exact component={ListEmployeeComponent} />
          <Route path="/employees" exact component={ListEmployeeComponent} />
          <Route path="/add-employee" exact component={AddEmployee} />
          <Route path="/update-employee/:id" exact render={({ match }) => <UpdateEmployee match={match} ></UpdateEmployee>} ></Route>
        </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
