package com.ycp.Classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Professional")
public class Professional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Professional_id")
	private long Pid;

	@Column(name = "First_name")
	private String First_name;

	@Column(name = "Middle_name")
	private String Middle_name;

	@Column(name = "Last_name")
	private String Last_name;

	@Column(name = "Password")
	private String password;

	@Column(name = "Mob_no")
	private String Mob_no;

	@Column(name = "Email_id")
	private String email;

	@Column(name = "DOB")
	private Date Dob;

	@Column(name = "Area")
	private String Area;

	@Column(name = "City")
	private String City;

	@Column(name = "State")
	private String State;

	@Column(name = "Country")
	private String Country;

	@Column(name = "Pincode")
	private String pincode;

	@Column(name = "Fees")
	private int fees;

	@Column(name = "Langauges")
	private String Langauges;

	@Column(name = "Working_Since")
	private Date Working_Since;

	@Column(name = "Gender")
	private String Gender;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "Qualifi")
	private Qualifications Course_no;

	@Column(name = "Specialisation")
	private String Specialisation;

	@Column(name = "validation")
	private boolean validation;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewdid")
	private List<Review> docreview = new ArrayList<Review>();

	public Professional() {

	}

	public long getPid() {
		return Pid;
	}

	public void setPid(long pid) {
		Pid = pid;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getMiddle_name() {
		return Middle_name;
	}

	public void setMiddle_name(String middle_name) {
		Middle_name = middle_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMob_no() {
		return Mob_no;
	}

	public void setMob_no(String mob_no) {
		Mob_no = mob_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getLangauges() {
		return Langauges;
	}

	public void setLangauges(String langauges) {
		Langauges = langauges;
	}

	public Date getWorking_Since() {
		return Working_Since;
	}

	public void setWorking_Since(Date working_Since) {
		this.Working_Since = working_Since;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getSpecialisation() {
		return Specialisation;
	}

	public Qualifications getCourse_no() {
		return Course_no;
	}

	public void setCourse_no(Qualifications course_no) {
		Course_no = course_no;
	}

	public void setSpecialisation(String specialisation) {
		Specialisation = specialisation;
	}

	public boolean isValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public List<Review> getDocreview() {
		return docreview;
	}

	public void setDocreview(List<Review> docreview) {
		this.docreview = docreview;
	}

}
