import { useState } from "react";
import Calendar from "react-calendar";

function SeeDateWiseBookAppointment() {
  const [date3, setDate] = useState();
  const [bookedslot, setbookedslot] = useState([]);
  const getAllBookedSlotesOnThatDay = (event) => {
    event.preventDefault();
    try {
      console.log(JSON.stringify(date3).substring(1, 11));

      const url =
        "http://localhost:8080/timetable/getAllBookedSlots/p/pid?p=" +
        JSON.stringify(date3).substring(1, 11) +
        "&pid=" +
        localStorage.getItem("Pid");
      fetch(url)
        .then((response) => response.json())
        .then((data) => {
          console.table(data);
          setbookedslot(data);
        })
        .catch((err) => {});
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <>
      <form>
        <Calendar onChange={setDate} />
        <button onClick={getAllBookedSlotesOnThatDay}>submit</button>
      </form>

      <table>
        <thead>
          <tr>
            <th>Data</th>
            <th>Pid</th>
            <th>Cid</th>
            <th>End</th>
            <th>start</th>
          </tr>
        </thead>
        {bookedslot.map((innerAttr, key) => {
          return (
            <>
              <tbody>
                <tr>
                  <td> {innerAttr.bookId.date}</td>
                  <td>{innerAttr.bookId.pid}</td>
                  <td>{innerAttr.bookId.cid}</td>
                  <td>{innerAttr.end}</td>
                  <td>{innerAttr.start}</td>
                  {/* <td>{innerAttr.dockey.dateOfAppointment}</td> */}
                </tr>
              </tbody>
            </>
          );
        })}
      </table>
    </>
  );
}
export default SeeDateWiseBookAppointment;
