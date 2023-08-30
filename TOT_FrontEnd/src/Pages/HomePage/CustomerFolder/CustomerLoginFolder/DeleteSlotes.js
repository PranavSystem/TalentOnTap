import { useEffect, useState } from "react";
import Button from "react-bootstrap/esm/Button";
import { Link, useLocation, useNavigate } from "react-router-dom";
function DeleteSlot() {
  const navigate = useNavigate();
  const [SlotesData, setSlotesData] = useState([]);
  const [message, setmessage] = useState("");
  const [Pid, setPid] = useState();
  const [AppointmentDate, setAppointmentDate] = useState();
  const [Cid, setCid] = useState();
  useEffect(() => {
    if (localStorage.getItem("Cid") == null) {
      navigate("/CustomerLogin");
    } else {
      navigate("/DeleteSlot");
    }
    let url =
      "http://localhost:8080/timetable/getBookedSlotByCustomer/key?key=" +
      localStorage.getItem("Cid");
    fetch(url)
      .then((response) => {
        if (response.ok) return response.json();
      })
      .then((data) => {
        console.log(data);
        if (data) setSlotesData(data);
        //     if(data.body==null)
        //    setmessage("You Don't Have Any Appointment")
      })
      .catch((err) => {
        // setmessage("You Don't Have Any Appointment")
      });
  }, []);

  function deleteThatSlot(event) {
    console.log("delete");
    console.log(Pid);
    console.log(AppointmentDate);
    console.log(Cid);
    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        pid: Pid,
        cid: Cid,
        date: AppointmentDate,
      }),
    };
    fetch("http://localhost:8080/timetable/cancelAppointment", requestOptions)
      .then((response) => response.json())
      .then(setmessage("You Don't have the booking"))
      .catch((err) => {
        console.log(err);
      });
  }

  return (
    <>
      <div className=" d-flex justify-content-end">
        <Link to={"/CustomerLogin"}>
          <input
            type={"button"}
            value="Logout"
            className=" border border-danger mt-3 me-5  btn btn-danger"
          />
        </Link>
      </div>
      <h3 className="text-center text-danger">{message}</h3>

      <div className="container w-50 table-responsive m-auto bg-white">
        <h3 className="m-3 text-center"> Appointment Slots</h3>
        <table className="table  table-bordered border border-dark  text-center">
          <thead className="table-dark">
            <tr>
              <td>Pid</td>
              <td>Date</td>
              <td>Cid</td>
              <td>Start</td>
              <td>End</td>
              <td>Action</td>
            </tr>
          </thead>
          <tbody>
            {SlotesData.map((Attr, key) => {
              return (
                <>
                  <tr>
                    <td> {Attr.bookId.pid}</td>
                    <td>{Attr.bookId.date}</td>
                    <td>{Attr.bookId.cid}</td>
                    <td>{Attr.start}</td>
                    <td>{Attr.end}</td>
                    <td>
                      <input
                        type="button"
                        value="Cancel "
                        className="btn btn-danger "
                        onClick={(e) => {
                          setPid(Attr.bookId.pid);
                          setCid(Attr.bookId.cid);
                          setAppointmentDate(Attr.bookId.date);
                        }}
                        onDoubleClick={(e) => deleteThatSlot()}
                      />
                    </td>
                  </tr>
                </>
              );
            })}
          </tbody>
        </table>
        <div className=" d-flex justify-content-center">
          <button className="btn btn-warning m-3">
            <Link to={"/CustomerAfterLoginLayout"}>Back</Link>
          </button>
        </div>
      </div>
    </>
  );
}
export default DeleteSlot;
