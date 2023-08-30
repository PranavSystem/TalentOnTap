import { Link, Outlet } from "react-router-dom";

const CustomerLayout = () => {
  return (
    <>
      <nav>
        <ul>
          <li>
            <Link to="/CustomerLogin">Customer Login</Link>
          </li>
          <li>
            <Link to="/CustomerSingUP">Customer SingUP</Link>
          </li>
        </ul>
      </nav>

      <Outlet />
    </>
  );
};
export default CustomerLayout;
