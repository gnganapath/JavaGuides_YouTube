import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import "./App.css";

import ListEmployeeComponent from "./components/ListEmployeeComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Route path="/" exact component={ListEmployeeComponent} />
          <Route path="/employees" exact component={ListEmployeeComponent} />
          {/* <ListEmployeeComponent /> */}
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
