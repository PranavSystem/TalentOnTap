import { useEffect } from "react";
import { Link, Navigate, Outlet } from "react-router-dom";
import { useNavigate } from "react-router-dom";
const ProfessionalLoginLayout = () => {
  const navigate = useNavigate();
  // const LogOut =()=>{
  //   localStorage.removeItem("Did")
  //   navigate("/DoctorLogin")
  // }
  useEffect(() => {
    if (localStorage.getItem("Pid") == null) {
      navigate("/ProfessionalLogin");
    }
  }, []);
  const logOut = () => {
    localStorage.removeItem("Pid");
    navigate("/ProfessionalLogin");
  };
  return (
    <>
      <h2 className="fw-bold text-center">
        {" "}
        Professional Id : {localStorage.getItem("Pid")}
      </h2>
      <div className=" d-flex justify-content-end">
        <Link to={"/CustomerLogin"}>
          <input
            type={"button"}
            value="Logout"
            onClick={logOut}
            className=" border border-danger mt-3 me-5  btn btn-danger"
          />
        </Link>
      </div>
      <div class="row1-container">
        <div class="box bg-white box-down cyan">
          <h3 className="dlayouth3">Create Appointments</h3>
          <p>Click Here To Create New Appiontment Slots</p>
          <Link to="/CreateAppointment">
            <button type="button" class="mt-3 btn btn-info">
              Create
            </button>
          </Link>
          <img
            src="https://assets.codepen.io/2301174/icon-supervisor.svg"
            alt=""
          />
        </div>

        <div class="box bg-white red">
          <h3 className="dlayouth3">Update Profile</h3>
          <p> Click Here TO Make Changes In Your Profile</p>
          <Link to="/UpDateProfessionalProfile">
            <button type="button" class="mt-3 btn btn-danger">
              Update
            </button>
          </Link>
          <img
            src="https://assets.codepen.io/2301174/icon-team-builder.svg"
            alt=""
          />
        </div>

        <div class="box bg-white box-down blue">
          <h3 className="dlayouth3">Update Appointment</h3>
          <p>Click Here to Change Created Appiontment Slots</p>
          <Link to="/ProfessionalUpdateCreatedSlotes">
            <button type="button" class="mt-3 btn btn-primary">
              Update
            </button>
          </Link>
          <img
            src="https://assets.codepen.io/2301174/icon-calculator.svg"
            alt=""
          />
        </div>
      </div>
      <div class="row2-container">
        <div class="box bg-white orange">
          <h3 className="dlayouth3">View Appointments</h3>
          <p>Click Here to View Already Created Appiontment Slots</p>
          <Link to="/ProfessionalSeeAllTheSlotes">
            <button type="button" class="mt-3 btn btn-warning">
              View
            </button>
          </Link>

          <img src="https://assets.codepen.io/2301174/icon-karma.svg" alt="" />
        </div>
      </div>

      <div class="row2-container">
        <div class="box bg-white orange">
          <h3 className="dlayouth3">View Booked Appointment</h3>
          <p>Click Here For See Date Wise Booked Appointment</p>
          <Link to="/SeeDateWiseBookAppointment">
            <button type="button" class="mt-3 btn btn-warning">
              View
            </button>
          </Link>

          <img src="https://assets.codepen.io/2301174/icon-karma.svg" alt="" />
        </div>
      </div>
      {/* 
        <nav>
          <ul>
            <li>
              <Link to="/CreateAppointment">CreateAppointment</Link>
            </li>
            <li>
              <Link to="/DoctorUpdateCreatedSlotes">DoctorUpdateCreatedSlotes</Link>
            </li>
            <li>
              <Link to="/DoctorSeeAllTheSlotes">DoctorSeeAllTheSlotes</Link>
            </li>
            <li>
              <Link to="/DoctorSeeAllSlotesDayWise">DoctorSeeAllSlotesDayWise</Link>
            </li>
            <li>
              <Link to="/UpDateDoctorProfile">UpDateDoctorProfile</Link>
            </li>
          </ul>
        </nav>
          */}
      <Outlet />
    </>
  );
};
export default ProfessionalLoginLayout;
