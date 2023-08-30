import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function DeleteProfessional() {
  const [Pid, setPid] = useState();
  const [DeleteUser, setDeletUser] = useState([]);
  const [Msg, setMsg] = useState([]);
  const navigate = useNavigate();
  const [ErrMsg, setErrMsg] = useState();
  useEffect(() => {
    if (localStorage.getItem("Aid") == null) {
      navigate("/AdminPage");
    }
  }, []);
  function getPro(event) {
    event.preventDefault();
    console.log("Inside the get All New Professionals");
    const url = "http://localhost:8080/professional/getOnePro/id?id=" + Pid;
    fetch(url)
      .then((response) => {
        console.log(response.status);
        if (response.status == 200) {
          return response.json();
        }
      })
      .then((data) => {
        if (data != null) {
          setDeletUser(data);
          console.log(data);
        } else {
          setErrMsg("Please Enter correct Professional Id");
        }
      })
      .catch((err) => {
        setErrMsg("Please Enter correct Professional Id");
      });
  }
  function deletePro(event) {
    event.preventDefault();
    console.log("Inside the get All New Professionals");
    const url = "http://localhost:8080/professional/DeleteMapping/id?id=" + Pid;
    fetch(url)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        setMsg("Deleted SuccessFully");
      })
      .catch((err) => {
        setMsg("Already Deleted");
      });
  }
  return (
    <>
      <div className="text-center">
        {" "}
        <h3>Delete Professional</h3>
      </div>

      <h1 className="text-danger text-center">{ErrMsg}</h1>
      <div className="container-sm  p-3  w-25 text-center m-auto shadow  mb-5 mt-5 bg-white rounded">
        <h5>{Msg}</h5>
        <form onSubmit={getPro}>
          <input
            placeholder="Enter Professional ID"
            className="form-control"
            type="text"
            onChange={(e) => setPid(e.target.value)}
          ></input>
          <button className="m-3 btn btn-primary">Submit</button>
          <div className=" d-flex justify-content-center">
            <button className="btn btn-warning m-3">
              <Link to={"/AdminPageLayout"}>Back</Link>
            </button>
          </div>
        </form>
      </div>

      {Object.keys(DeleteUser).map((innerAttr, index) => {
        return (
          <table class="table table-bordered w-75 m-auto table-hover">
            <tbody className="table-light border boder-warning border-2">
              <tr>
                <td className="w-25"> {innerAttr} </td>
                <td className="w-25">{DeleteUser[innerAttr]}</td>
              </tr>
            </tbody>
          </table>
        );
      })}
      <div className="text-center">
        <button className="btn btn-danger m-3" onClick={deletePro}>
          deletePro
        </button>
      </div>
    </>
  );
}
export default DeleteProfessional;
