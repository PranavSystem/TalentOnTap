import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

export default function CustomerLogin() {
  const navigate = useNavigate();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [Msg, setMsg] = useState();
  useEffect(() => {
    if (localStorage.getItem("Cid") == null) {
      navigate("/CustomerLogin");
    }
  }, []);

  function getUser(event) {
    console.log("inside Customer login");
    event.preventDefault();
    let url =
      "http://localhost:8080/customer/customerLogin/email/password?email=" +
      email +
      "&password=" +
      password;
    console.log(email);
    console.log(password);

    fetch(url)
      .then((response) => {
        console.log(response.status);
        console.log(response.data);
        console.log("fine2");
        if (response.ok) {
          return response.json();
        } else {
          console.log("backend error");
        }
      })
      .then((data) => {
        if (data) {
          console.log("fine1");
          console.table(data);
          console.log(data.cid);
          //  <Link to={{pathname:"/PatietAfterLoginLayout" ,state: {data}}}></Link>

          localStorage.setItem("Cid", data.cid);

          navigate("/CustomerAfterLoginLayout");
          setMsg("");
        }
      })
      .catch((err) => {
        setMsg("Please Enter Correct User Name And PassWord");
      });
  }
  return (
    <>
      <div className="container con" id="container">
        <div className="form-container sign-in-container">
          <form className="forml" onSubmit={getUser}>
            <h1 className="mb-3">Sign in</h1>
            <h6 className="text-danger">{Msg}</h6>

            <input
              type="email"
              id="email"
              placeholder="Email"
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <input
              type="password"
              id="password"
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
              required
            />

            <button className="m-2 buttonn" type="submit">
              Sign In
            </button>

            <Link className="m-2" to="/RegisterCustomer">
              {" "}
              Sign up
            </Link>
            <div className=" d-flex justify-content-start">
              <button className="btn btn-warning m-4">
                <Link to={"/"}>Back</Link>
              </button>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}
