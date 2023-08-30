package com.ycp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ycp.Classes.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

	// @QUERY(NAME ="SELECT * FROM DTABLE LEFT OUTER JOIN QUALIFICATION ON
	// DTABLE.COURSE_NO = QUALIFICATION.COURSE_NO",NATIVEQUERY = TRUE)
	// public List<Doctor> findByQuali(Qualifications q);

	// @Query(name = "select * from dtable where pincode = ?",nativeQuery = true)
	public List<Professional> findByPincode(String pincode);

	// public List<Doctor> finByQuali(Qualifications q);
	public Professional findByEmailAndPassword(String emial, String password);

	public List<Professional> findByValidation(boolean val);

	public Professional findByEmail(String email);

}
