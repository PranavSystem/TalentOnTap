import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
function AcceptNewProfessional() {
  const [NewUser, setNewUser] = useState([]);
  const [Pid, setPid] = useState();
  const [mgs, setMsg] = useState();
  const navigate = useNavigate();
  useEffect(() => {
    if (localStorage.getItem("Aid") == null) {
      navigate("/AdminPage");
    }
  }, []);
  function getAllNewProfessionals(event) {
    event.preventDefault();
    console.log("Inside the get All New Professionals");
    const url =
      "http://localhost:8080/professional/validation/value?value=false";
    fetch(url)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        setNewUser(data);
        console.table(data);
        console.log(data);
      });
  }
  function MakeAValidProfessional(event) {
    event.preventDefault();
    console.log("Inside the get All New Professional");
    const url =
      "http://localhost:8080/professional/UpdateValidation/id?id=" + Pid;
    fetch(url)
      .then()
      .then(setMsg("Validation Done"))
      .catch((err) => {
        setMsg("validation Falied");
      });
  }
  return (
    <>
      <div className="text-center">
        <h3>Accept Professional Application</h3>
        <h5>{mgs}</h5>
        <button
          className="btn btn-success m-5 "
          onClick={getAllNewProfessionals}
        >
          Get All New Professionals
        </button>
      </div>
      <table className="bg-white table  w-75 text-center m-auto mt-5 table-bordered table-hover">
        <thead className=" table-dark">
          <tr>
            <th>PID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile Number</th>
            <th>Specialisation</th>
            <th>Area</th>
            <th>State</th>
            <th>pincode</th>
            <th>Country</th>
            <th>Validation</th>
            <th>Action</th>
          </tr>
        </thead>
        {NewUser.map((Attri, key) => {
          return (
            <>
              <tbody>
                <tr>
                  <td>{Attri.pid}</td>
                  <td>{Attri.first_name}</td>
                  <td>{Attri.last_name}</td>
                  <td>{Attri.email}</td>
                  <td>{Attri.mob_no}</td>
                  <td>{Attri.specialisation}</td>
                  <td>{Attri.area}</td>
                  <td>{Attri.state}</td>
                  <td>{Attri.pincode}</td>
                  <td>{Attri.country}</td>
                  <td>{Attri.validation}</td>
                  <td>
                    <button
                      onDoubleClick={MakeAValidProfessional}
                      className="btn btn-success"
                      onClick={(e) => setPid(Attri.pid)}
                    >
                      Validate
                    </button>
                  </td>
                </tr>
              </tbody>
            </>
          );
        })}
      </table>

      <div className=" d-flex justify-content-center">
        <button className="btn btn-warning m-3">
          <Link to={"/AdminPageLayout"}>Back</Link>
        </button>
      </div>
    </>
  );
}
export default AcceptNewProfessional;
