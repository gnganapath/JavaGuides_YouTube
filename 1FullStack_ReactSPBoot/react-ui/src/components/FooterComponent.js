import React from "react";

const FooterComponent = () => {
  const copyright = "sundaresan";
  return (
    <footer className="footer">
      <span className="text-muted">
        All Rights Reserved 2020 @java {copyright}
      </span>
      <div className="btn btn-primary">
        React JS 16.13 for UI && spring boot 2.3.2 for (server scrpipt) middle
        ware && Maria DB 10.4 as DB - Dev Tech stack
      </div>
    </footer>
  );
};
export default FooterComponent;
