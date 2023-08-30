import { Link, Outlet } from "react-router-dom";

const ProfessionalLayout = () => {
  return (
    <>
      <nav>
        <ul>
          <li>
            <Link to="/ProfessionalLogin">Professional Login</Link>
          </li>
          <li>
            <Link to="/ProfessionalRegister">Sign Up</Link>
          </li>
        </ul>
      </nav>

      <Outlet />
    </>
  );
};
export default ProfessionalLayout;
