package com.ycp.Classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Qualification")
public class Qualifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quali_id")
	private int Id;
	@Column(name = "certificate")
	private String certificate;
	@JsonIgnore
	@OneToMany(mappedBy = "Course_no", cascade = CascadeType.ALL)
	private List<Professional> pro = new ArrayList<Professional>();

	public Qualifications() {

	}

	public Qualifications(int id) {
		super();
		Id = id;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public List<Professional> getPro() {
		return pro;
	}

	public void setPro(List<Professional> pro) {
		this.pro = pro;
	}

}
