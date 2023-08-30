package com.ycp.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ycp.Classes.Professional;
import com.ycp.Classes.Qualifications;
import com.ycp.Repository.ProfessionalRepository;
import com.ycp.Repository.QualiRepository;

@Service
@Transactional
public class ProfessionalServices {

	@Autowired
	private ProfessionalRepository prepo;
	@Autowired
	private QualiRepository qrepo;

	public List<Qualifications> getAll() {

		List<Qualifications> quali = qrepo.findAll();
		return quali;
	}

	public List<Professional> getAllpro() {

		List<Professional> quali = prepo.findAll();
		return quali;
	}

	public Qualifications findProInArea(@RequestParam String certificate, @RequestParam String pincode) {
		Qualifications q = qrepo.findByCertificateAndProPincode(certificate, pincode);
		return q;
	}

	public void addProfessional(Professional pro) {

		try {
			MessageDigest dutil = MessageDigest.getInstance("SHA-256");
			String sha256hex = DigestUtils.sha256Hex(pro.getPassword());
			pro.setPassword(sha256hex);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("in add professional service");
			e.printStackTrace();
		}
		prepo.save(pro);
		System.out.println("Professional Created");
	}

	public Qualifications getOne(int id) {
		Qualifications q = qrepo.getById(id);
		return q;
	}

	public Professional getOnePro(long id) {
		Professional pro = prepo.findById(id).get();
		return pro;
	}

	public Professional loginProfessional(String email, String password) {
		String sha256hex = null;
		try {
			MessageDigest dutil = MessageDigest.getInstance("SHA-256");
			sha256hex = DigestUtils.sha256Hex(password);

		} catch (NoSuchAlgorithmException e) {
			System.out.println("Inside backend Professional");
			e.printStackTrace();
		}

		Professional pro = prepo.findByEmailAndPassword(email, sha256hex);
		System.out.println("password = " + pro.getPassword());
		System.out.println(sha256hex);
//		System.out.println("area ="+doc.getArea());
		if (pro != null) {
			if (pro.getEmail().equals(email) && pro.getPassword().equals(sha256hex)) {
				System.out.println("inside doctor ");
				// if(doc.isValidation()==true)
				return pro;
			} else {

				return null;
			}
		}

		return null;
	}

	public void updateProfessional(Professional doc) {
		Professional temp = prepo.findById(doc.getPid()).get();
		if (!temp.getFirst_name().equals(doc.getFirst_name())) {
			temp.setFirst_name(doc.getFirst_name());
		}
		if (!temp.getLast_name().equals(doc.getLast_name())) {
			temp.setFirst_name(doc.getLast_name());
		}
		if (!temp.getMiddle_name().equals(doc.getMiddle_name())) {
			temp.setMiddle_name(doc.getMiddle_name());
		}

		if (!temp.getMob_no().equals(doc.getMob_no())) {
			temp.setMob_no(doc.getMob_no());
		}
		if (!temp.getEmail().equals(doc.getEmail())) {
			temp.setEmail(doc.getEmail());
		}
		if (!temp.getDob().equals(doc.getDob())) {
			temp.setDob(doc.getDob());
		}
		if (!temp.getArea().equals(doc.getArea())) {
			temp.setArea(doc.getArea());
		}
		if (!temp.getCity().equals(doc.getCity())) {
			temp.setCity(doc.getCity());
		}
		if (!temp.getState().equals(doc.getState())) {
			temp.setState(doc.getState());
		}
		if (!temp.getCountry().equals(doc.getCountry())) {
			temp.setCountry(doc.getCountry());
		}
		if (!temp.getPincode().equals(doc.getPincode())) {
			temp.setPincode(doc.getPincode());
		}
		if (temp.getFees() != doc.getFees()) {
			temp.setFees(doc.getFees());
		}
		if (!temp.getLangauges().equals(doc.getLangauges())) {
			temp.setLangauges(doc.getLangauges());
		}
		if (!temp.getWorking_Since().equals(doc.getWorking_Since())) {
			temp.setWorking_Since(doc.getWorking_Since());
		}
		if (!temp.getGender().equals(doc.getGender())) {
			temp.setGender(doc.getGender());
		}

		prepo.save(temp);
		System.out.println("Doctor updated succesefully");
	}

	public List<Professional> findByPincode(String pincode) {
		List<Professional> dlist = prepo.findByPincode(pincode);
		return dlist;
	}

	public List<Professional> findByValidation(boolean value) {
		List<Professional> list = prepo.findByValidation(value);
		return list;
	}

	public void ValidationUpdation(long id) {
		Professional pro = prepo.findById(id).get();
		pro.setValidation(true);
		prepo.save(pro);
		System.out.println("Validation Done");
	}

	public void DeleteProfessional(long Pid) {
		prepo.deleteById(Pid);
	}

	public String checkForEmail(String email) {
		Professional pro = prepo.findByEmail(email);
		if (pro != null) {
			if (pro.getEmail().equals(email))
				return pro.getEmail();
		}

		return null;
	}

}
