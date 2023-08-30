package com.ycp.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ycp.Classes.BookAppointmentKey;
import com.ycp.Classes.BookedAppointment;
import com.ycp.Classes.ProfessionalTimeTable;
import com.ycp.Classes.ProfessionalTimeTableKey;
import com.ycp.Services.ProfessionalAppointmentService;

@RequestMapping("/timetable")
@CrossOrigin(origins = "*")
@RestController
public class ProfessionalTimetableController {
	@Autowired
	private ProfessionalAppointmentService pTimeService;

	// get all the slots from the database from professional timetable;
	@GetMapping("/getAll")
	public List<ProfessionalTimeTable> getAllAppointments() {
		List<ProfessionalTimeTable> list = pTimeService.getAllAppointments();
		return list;
	}

	// professional can Add and update slot inside professional timetable ;
	@PostMapping("/addSlot")
	public void addSlote(@RequestBody ProfessionalTimeTable pt) {
		System.out.println("in add slotes");
		System.out.println(pt.getProkey() + " and" + pt.getBreakTime_end() + " and" + pt.getBreakTime_start() + "and "
				+ pt.getProkey().getId() + " " + pt.getEnd_Time() + " " + pt.getSlotDuration() + " "
				+ pt.getStart_Time());
		pTimeService.addSlot(pt);
	}

	// get all the slots which are available for particular date.
	@PostMapping("/getslot")
	public Map<String, String> getSlot(@RequestBody ProfessionalTimeTableKey key) {
		System.out.println(key.getId() + " " + key.getDateOfAppointment());

		Map<String, String> p = pTimeService.getSlots(key);
		System.out.println(p);
		return p;
	}

	@GetMapping("/getBookedSlotMadeByProfessionalsDailly/{key}")
	public List<ProfessionalTimeTable> getTheDateWiseAppointment(@RequestParam long key) {
		List<ProfessionalTimeTable> papp = pTimeService.getTheDateWiseAppointment(key);
		return papp;
	}

	@GetMapping("/getBookedSlotByCustomer/{key}")
	public List<BookedAppointment> getBookedSlotByPatient(@RequestParam long key) {
		List<BookedAppointment> bapp = pTimeService.getPatientBookedSlot(key);
		return bapp;

	}

	// get all booked slots for particular date and did from book slots table
	@GetMapping("/getAllBookedSlots/{d}/{did}")
	public List<BookedAppointment> getAllBookedSlotForDay(@RequestParam Date d, @RequestParam long did) {
		System.out.println(did);
		List<BookedAppointment> list = pTimeService.getAllBookedSlotForDay(d, did);
		return list;
	}

	// to book appointment inside book slots table
	@PutMapping("/saveTheApointment")
	public void bookApointment(@RequestBody BookedAppointment bapp) {
		System.out.println("did= " + bapp.getBookId().getPid());
		pTimeService.bookApointment(bapp);
	}// Cancel

	@PostMapping("/cancelAppointment")
	public void cancelAppointment(@RequestBody BookAppointmentKey key) {
		System.out.println(key.getPid());
		System.out.println(key.getCid());
		System.out.println(key.getDate());
		pTimeService.cancelAppointment(key);

	}

}
