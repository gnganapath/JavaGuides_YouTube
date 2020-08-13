import React from "react";

// method 1 - define functional component - export and function both are in same line
export default function HeaderComponent() {
  return (
    <>
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <div>
            <a href="https://javaguides.net" className="navbar-brand">
              Employee Management App - with Functional Component - Hooks based
            </a>
            <a href="https://www.javaguides.net/2020/07/spring-boot-react-js-crud-example-tutorial-react-app-frontend-part2.html">
              {" "}
              Ref: Class based componets UI{" "}
            </a>
          </div>
        </nav>
      </header>
    </>
  );
}
