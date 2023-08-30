import { useEffect, useState } from "react";
import Button from "react-bootstrap/esm/Button";
import { Link, useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function UpdateSlotes() {
  const navigate = useNavigate();

  const [SlotesData, setSlotesData] = useState([]);
  const [message, setmessage] = useState("");
  const [Pid, setPid] = useState();
  const [AppointmentDate, setAppointmentDate] = useState();
  const [Cid, setCid] = useState();
  const [AvailableSlotes, setAvailableSlotes] = useState([]);
  const [StartTimeSlot, setStartTimeSolt] = useState();
  const [EndTimeSlot, setEndTimeSolt] = useState();
  useEffect(() => {
    if (localStorage.getItem("Cid") == null) {
      navigate("/CustomerLogin");
    } else {
      navigate("/UpdateSlotes");
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
      });
  }, []);

  const SeeAllAvailableSlotes = () => {
    console.log(Pid);
    console.log(AppointmentDate);

    try {
      const requestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          id: Pid,
          dateOfAppointment: AppointmentDate,
        }),
      };
      fetch("http://localhost:8080/timetable/getslot", requestOptions)
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
          setAvailableSlotes(data);
        });
    } catch (e) {
      console.log(e);
    }
  };
  const finallyUpdateThatSlote = () => {
    alert("Do You want to Update ");
    console.log(StartTimeSlot);
    console.log(EndTimeSlot);
    console.log(StartTimeSlot);
    console.log(EndTimeSlot);

    try {
      const requestOptions = {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          bookId: {
            pid: Pid,
            date: AppointmentDate,
            cid: Cid,
          },
          start: StartTimeSlot,
          end: EndTimeSlot,
        }),
      };
      fetch("http://localhost:8080/timetable/saveTheApointment", requestOptions)
        .then((response) => response.json())
        .then(navigate("/CustomerAfterLoginLayout"));
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <>
      <h3 className="text-center text-danger mt-3">{message}</h3>
      {SlotesData.map((Attr, key) => {
        return (
          <>
            <table className="table  table-bordered border border-dark  text-center m-auto w-75 mb-3">
              <thead className="table-dark">
                <tr>
                  <th>Pid</th>
                  <th>Date</th>
                  <th>Pid</th>
                  <th>Start</th>
                  <th>End</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td> {Attr.bookId.pid}</td>
                  <td>{Attr.bookId.date}</td>
                  <td>{Attr.bookId.cid}</td>
                  <td>{Attr.start}</td>
                  <td>{Attr.end}</td>
                  <td>
                    <input
                      type={"button"}
                      value={"See All The Apointment To Update"}
                      className="btn btn-danger"
                      onClick={(e) => {
                        setPid(Attr.bookId.pid);
                        setAppointmentDate(Attr.bookId.date);
                        setCid(Attr.bookId.cid);
                      }}
                      onDoubleClick={(e) => {
                        SeeAllAvailableSlotes();
                      }}
                    />
                  </td>
                </tr>
              </tbody>
            </table>
          </>
        );
      })}
      <div className="bg-white container-sm  border table-responsive border-2 w-75 mb-3 mt-4 border-warning border-4">
        <div className="row p-3">
          {Object.keys(AvailableSlotes).map((innerAttr, index) => {
            return (
              <>
                <div className="col-lg-3">
                  <Button
                    className="m-3"
                    onDoubleClick={finallyUpdateThatSlote}
                    onClick={(e) => {
                      setStartTimeSolt(innerAttr);
                      setEndTimeSolt(AvailableSlotes[innerAttr]);
                    }}
                  >
                    {innerAttr} - {AvailableSlotes[innerAttr]}
                  </Button>
                </div>
              </>
            );
          })}
        </div>
      </div>

      <div className=" d-flex justify-content-center">
        <button className="btn btn-warning m-3">
          <Link to={"/CustomerAfterLoginLayout"}>Back</Link>
        </button>
      </div>
    </>
  );
}
export default UpdateSlotes;
