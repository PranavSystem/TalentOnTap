package com.tot.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tot.Classes.BookAppointmentKey;
import com.tot.Classes.BookedAppointment;

@Repository
public interface BookSlotRepository extends JpaRepository<BookedAppointment, BookAppointmentKey> {
	public List<BookedAppointment> findByBookIdCid(long key);

	public List<BookedAppointment> findByBookIdPid(long key);

	public List<BookedAppointment> findByBookIdDateAndBookIdPid(Date d, long pid);

	public BookedAppointment deleteByBookId(BookAppointmentKey id);
}
