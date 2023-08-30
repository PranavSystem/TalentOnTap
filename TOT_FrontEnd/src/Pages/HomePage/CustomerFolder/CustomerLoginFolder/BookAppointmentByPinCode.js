import { useEffect, useState } from "react";
import Button from "react-bootstrap/esm/Button";
import { Link, useLocation, useNavigate } from "react-router-dom";
// var express = require('express');

function BookAppointmentByPinCode(props) {
  const navigate = useNavigate();
  const [Pincode, setPicode] = useState();
  const [Counter, setCouter] = useState(0);
  const [ListOfProfessionalFormPicode, setListOfProfessionalFormPicode] =
    useState([]);
  const [Pid, setPid] = useState();
  const [TimeSlote, setTimeSlote] = useState([]);
  const [AppointmentDate, setAppointmentDate] = useState();
  const [AvailableSlotes, setAvailableSlotes] = useState([]);
  const [StartTimeSlot, setStartTimeSolt] = useState();
  const [EndTimeSlot, setEndTimeSolt] = useState();

  useEffect(() => {
    if (localStorage.getItem("Cid") == null) {
      navigate("/CustomerLogin");
    }
  }, []);

  const location = useLocation();
  function checklength(event) {
    if (event.target.value.length <= 6) {
      setPicode(event.target.value);
    }
  }
  function getAllProfessionalsFromGivenArea(event) {
    event.preventDefault();
    let url =
      "http://localhost:8080/professional/getByPincode/pincode?pincode=" +
      Pincode;
    console.log(url);
    fetch(url)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        setListOfProfessionalFormPicode(data);
        console.log(data);
      })
      .catch((err) => {
        console.log("No Professional for this pincode");
      });
  }
  const SeeAllDayWiseAppointment = (event) => {
    // console.log(Did)
    // changed
    //  event.AvailableSlotes();
    let url =
      "http://localhost:8080/timetable/getBookedSlotMadeByProfessionalsDailly/key?key=" +
      Pid;

    fetch(url)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        setTimeSlote(data);
      })
      .catch((err) => {
        console.log("About error" + err);
      });
  };
  const SeeAllAvailableSlotes = (event) => {
    console.log(Pid);
    console.log(AppointmentDate);
    // changed
    //event.EndTimeSlot();
    try {
      const requestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          id: Pid,
          dateOfAppointment: AppointmentDate,
        }),
      };
      console.log("here");
      fetch("http://localhost:8080/timetable/getslot", requestOptions)
        .then((response) => response.json())
        .then((data) => {
          console.log("there");
          setAvailableSlotes(data);
        })
        .catch((error) => {
          console.error("Error ", error);
        });
    } catch (e) {
      console.log(e);
    }
  };
  const finallyBookThatslot = (event) => {
    event.preventDefault();
    console.log(StartTimeSlot);
    console.log(EndTimeSlot);
    alert("Do U want To Book Slot");
    console.log(StartTimeSlot);
    console.log(EndTimeSlot);
    console.log(Pid);
    try {
      const requestOptions = {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          bookId: {
            pid: Pid,
            date: AppointmentDate,
            cid: localStorage.getItem("Cid"),
          },
          start: StartTimeSlot,
          end: EndTimeSlot,
        }),
      };
      fetch("http://localhost:8080/timetable/saveTheApointment", requestOptions)
        .then((response) => response.json())
        .catch((error) => {
          console.error("Error ", error);
          // .then( navigate("/PatietAfterLoginLayout"))
        });
    } catch (e) {
      console.log(e);
    }
  };
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
      {/* <h5 className="text-danger text-center">{}</h5> */}
      <div className=" container-sm  w-50   m-auto text-center">
        <form
          className=" bg-white text-center formm  m-auto shadow pt-4 border border-primary border-3 mb-5 mt-5 rounded"
          onSubmit={getAllProfessionalsFromGivenArea}
        >
          <label className="form-label ">Enter Pincode </label>
          <div className="d-flex justify-content-center">
            {" "}
            <input
              className=" form-control mt-2 w-50 border-2"
              type={"number"}
              onChange={(e) => setPicode(e.target.value)}
              required
            />
          </div>

          <input type={"submit"} className="buttonn m-3 " name={"submit"} />
          <div className=" d-flex justify-content-center">
            <button className="btn btn-warning m-3">
              <Link to={"/CustomerAfterLoginLayout"}>Back</Link>
            </button>
          </div>
        </form>
      </div>
      <h4 className="text-center fw-500  m-3">Available Professional</h4>
      <div className=" bg-white container-sm  table-responsive m-auto border border-3  w-75 mb-5 p-3">
        <table className="table table-striped  table-bordered border border-dark  text-center">
          <thead className="table-dark">
            <tr>
              <th> Professional </th>
              <th>city</th>
              <th>area</th>

              <th>pincode</th>
              <th>fees</th>
              <th>Working since</th>
              <th>specialisation</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {ListOfProfessionalFormPicode.map((innerAttr, key) => {
              return (
                <>
                  <tr>
                    <td>
                      {" "}
                      {innerAttr.first_name} {innerAttr.last_name}
                    </td>
                    <td>{innerAttr.city}</td>
                    <td>{innerAttr.area}</td>

                    <td>{innerAttr.pincode}</td>
                    <td>{innerAttr.fees}</td>
                    <td>{innerAttr.working_since}</td>
                    <td>{innerAttr.specialisation}</td>
                    <td>
                      <input
                        className="btn btn-primary"
                        onDoubleClick={SeeAllDayWiseAppointment}
                        onClick={() => setPid(innerAttr.pid)}
                        value="Slotes"
                      />
                    </td>
                  </tr>
                </>
              );
            })}
          </tbody>
        </table>
      </div>

      <h4 className="text-center fw-500  m-3">Available Day For Appointment</h4>
      <div className=" bg-white container-sm border table-responsive mb-5 border-3  w-75  p-3">
        <table className="table table-striped  table-bordered border border-dark  text-center">
          <thead className="table-dark">
            <tr>
              <th>Start Time</th>
              <th>End Time</th>
              <th>Duration</th>

              <th>Date</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {TimeSlote.map((slotesInfo, key) => {
              return (
                <>
                  <tr>
                    <td> {slotesInfo.start_Time}</td>
                    <td>{slotesInfo.end_Time}</td>
                    <td>{slotesInfo.slotDuration}</td>

                    <td>{slotesInfo.prokey.dateOfAppointment}</td>
                    <td>
                      <input
                        className="btn btn-primary"
                        onDoubleClick={SeeAllAvailableSlotes}
                        value="View Slots"
                        onClick={() => {
                          setAppointmentDate(
                            slotesInfo.prokey.dateOfAppointment
                          );
                        }}
                      />
                    </td>
                  </tr>
                </>
              );
            })}
          </tbody>
        </table>
      </div>
      <h4 className="text-center fw-500 m-3">Available Slots</h4>
      <div className="bg-white container-sm  border table-responsive border-2 w-75 mb-3">
        <div className="row p-3">
          {Object.keys(AvailableSlotes).map((innerAttr, index) => {
            return (
              <>
                <div className="col-lg-3">
                  <Button
                    className="m-3"
                    onDoubleClick={finallyBookThatslot}
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
    </>
  );
}
export default BookAppointmentByPinCode;
