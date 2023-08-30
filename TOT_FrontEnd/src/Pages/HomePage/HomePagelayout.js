import { Link } from "react-router-dom";
import "../HomePage/Homepagelayout.css";
import "bootstrap/dist/css/bootstrap.min.css";

const HomepageLayout = () => {
  return (
    <>
      <div className="homediv p-5 text-center w-50   ">
        <div className="mt-4">
          <Link className="m-3" to={"/CustomerLogin"}>
            <button type="button" className="btn btn-info">
              {" "}
              <h3>Customer</h3>
            </button>
          </Link>

          <Link className="m-3" to={"/ProfessionalLogin"}>
            <button type="button" className="btn btn-info">
              {" "}
              <h3>Professionals</h3>
            </button>
          </Link>

          <Link className="m-3" to={"/AdminPage"}>
            <button type="button" className="btn btn-info">
              <h3>Admin</h3>
            </button>
          </Link>
        </div>
      </div>
      <div class="  footer  m-auto">
        <p> TOT </p>
      </div>
    </>
  );
};

export default HomepageLayout;
