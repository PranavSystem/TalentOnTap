package com.tot.Classes;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProfessionalTimeTableKey implements Serializable {

	@Column(name = "Pro_Pid")
	private long id;

	@Column(name = "DateOfAppointment")
	private Date DateOfAppointment;

	public ProfessionalTimeTableKey() {
		super();
	}

	public ProfessionalTimeTableKey(long did, Date dateOfAppointment) {
		super();
		id = did;
		DateOfAppointment = dateOfAppointment;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id, DateOfAppointment);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProfessionalTimeTableKey pk = (ProfessionalTimeTableKey) o;
		return Objects.equals(id, pk.id) && Objects.equals(DateOfAppointment, pk.DateOfAppointment);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateOfAppointment() {
		return DateOfAppointment;
	}

	public void setDateOfAppointment(Date dateOfAppointment) {
		DateOfAppointment = dateOfAppointment;
	}

}
