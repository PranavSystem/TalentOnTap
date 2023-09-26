package com.tot.Services;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tot.Classes.BookAppointmentKey;
import com.tot.Classes.BookedAppointment;
import com.tot.Classes.ProfessionalTimeTable;
import com.tot.Classes.ProfessionalTimeTableKey;
import com.tot.Repository.BookSlotRepository;
import com.tot.Repository.ProTimeTableRepository;

@Service
@Transactional
public class ProfessionalAppointmentService {
	@Autowired
	private ProTimeTableRepository ptimerepo;

	@Autowired
	private BookSlotRepository bookSloteRepo;

	public List<ProfessionalTimeTable> getAllAppointments() {
		List<ProfessionalTimeTable> list = ptimerepo.findAll();

		return list;
	}

	public void addSlot(ProfessionalTimeTable pt) {
		ptimerepo.save(pt);
		System.out.println("new slot added");
	}

	public Map<String, String> getSlots(ProfessionalTimeTableKey key) {
		System.out.println("id= " + key.getId());
		ProfessionalTimeTable p = ptimerepo.findByProkey(key);
		System.out.println("not null" + p);
		if (p == null) {
			return null;
		}
		System.out.println();
		// d.toString();
		Map<String, String> tset = null;
		if (p != null) {
			Time start_t = p.getStart_Time();
			Time End_t = p.getEnd_Time();
			Time break_start_t = p.getBreakTime_start();
			Time break_end_t = p.getBreakTime_end();
			Time slotDuration = p.getSlotDuration();
			System.out.println(slotDuration.toString().substring(3, 5));
			// Integer.parseInt(slotDuration.toString());
			// Integer.parseInt(start_t.toString());
			System.out.println(start_t.toString().substring(0, 2).concat(start_t.toString().substring(3, 5)));
			List<String> t = new ArrayList<String>();
			for (Time i = start_t; !i.equals(End_t);) {
				t.add(i.toString());
				int min = i.getMinutes() + slotDuration.getMinutes();
				if (min >= 60) {
					int hr = i.getHours() + (min / 60);
					int min2 = min % 60;
					i.setHours(hr);
					i.setMinutes(min2);

				} else {
					i.setMinutes(min);

				}
				System.out.print(i + "  ");
			}
			System.out.println("map started");
			tset = new HashMap<String, String>();
			for (int i = 0; i < t.size() - 1; i++) {
				tset.put(t.get(i), t.get(i + 1));
			}
			tset.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));
			////////////////////////////////////////////////

			List<String> breTimes = new ArrayList<String>();
			System.out.println("Break Time end " + break_end_t);
			System.out.println("Break Time start" + break_start_t);

			for (Time c = break_start_t; !c.equals(break_end_t);) {
				breTimes.add(c.toString());
				System.out.print(c + "  Break Time Start");
				int min = c.getMinutes() + slotDuration.getMinutes();
				System.out.println("total min" + min);

				if (min >= 60) {
					int hr = c.getHours() + (min / 60);
					int min2 = min % 60;
					c.setHours(hr);
					c.setMinutes(min2);

				} else {
					c.setMinutes(min);

				}
			}
			Iterator<String> it1 = tset.keySet().iterator();
			for (String time : breTimes) {
				while (it1.hasNext()) {
					String key44 = it1.next();
					if (key44.equals(time)) {
						it1.remove();
						break;
					}
				}
			}
			Map<String, String> breakSlotDuration = new HashMap<String, String>();
			for (int i = 0; i < breTimes.size() - 1; i++) {
				// System.out.println(breTimes.get(i).toString()+"
				// "+breTimes.get(i+1).toString());
				breakSlotDuration.put(breTimes.get(i).toString(), breTimes.get(i + 1).toString());
			}

			breakSlotDuration.forEach(
					(k, v) -> System.out.println("breakSlotDuration Key = " + k + ",breakSlotDuration Value = " + v));
		}
		System.out.println("list started");

		List<BookedAppointment> list = bookSloteRepo.findByBookIdDateAndBookIdPid(key.getDateOfAppointment(),
				key.getId());
		System.out.println("list" + list);
		if (list != null) {
			Iterator<String> it1 = tset.keySet().iterator();
			while (it1.hasNext()) {
				String key44 = it1.next();
				// System.out.println(key44);
				for (int i = 0; i < list.size(); i++) {
					String tom = list.get(i).getStart().toString();

					if (key44.equals(tom)) {
						it1.remove();
						break;
					}
				}
			}
		}
		for (Map.Entry<String, String> entry : tset.entrySet()) {
			// System.out.println(entry.getKey()+" "+entry.getValue());
		}
		System.out.println(tset.size());

		return tset;
	}

	public List<BookedAppointment> getPatientBookedSlot(Long key) {
		List<BookedAppointment> bapp = bookSloteRepo.findByBookIdPid(key);
		return bapp;
	}

	public List<BookedAppointment> getAllBookedSlotForDay(Date d, long did) {

		List<BookedAppointment> list = bookSloteRepo.findByBookIdDateAndBookIdPid(d, did);
		return list;
	}

	public void bookApointment(BookedAppointment bapp) {
		System.out.println(bapp.getBookId().getPid());
		bookSloteRepo.save(bapp);
		System.out.println("Saved succesfull");
	}

	public void cancelAppointment(BookAppointmentKey key) {
		bookSloteRepo.deleteById(key);
		System.out.println("Appointment Canceled");
	}

	public List<ProfessionalTimeTable> getTheDateWiseAppointment(@RequestBody long key) {
		List<ProfessionalTimeTable> bapp = ptimerepo.findByProkeyId(key);
		return bapp;
	}
}
