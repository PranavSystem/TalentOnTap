package com.tot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tot.Classes.Professional;
import com.tot.Classes.Qualifications;
import com.tot.Services.ProfessionalServices;

@CrossOrigin(origins = "*")
@RequestMapping("/professional")
@RestController

public class ProfessionalController {
	@Autowired
	private ProfessionalServices pservice;

	@Autowired
	private QualificationController qcontroller;

	// this is used to display all the constraint.
	@GetMapping("/OneToMany")
	public List<Qualifications> getAll() {
		List<Qualifications> list = pservice.getAll();
		return list;
	}

	// this is used to display all the constraint.
	@GetMapping("/MayToOne")
	public List<Professional> getAllPro() {
		List<Professional> list = pservice.getAllpro();
		return list;
	}

	// this is used to show number of doctors available in the region.
	@PostMapping("/Pincode2/{medicalCourse}/{pin}")
	public Qualifications findDocInArea(@RequestParam String medicalCourse, @RequestParam String pin) {
		System.out.println(medicalCourse + "  " + pin);
		Qualifications q = pservice.findProInArea(medicalCourse, pin);
		return q;
	}

	// this is used to Create new professional.
	@PostMapping("/addProfessional")
	public void addProfessional(@RequestBody Professional p) {
		pservice.addProfessional(p);
	}

	@GetMapping("/getOne/{id}")
	public Qualifications getOne(@RequestParam int id) {
		Qualifications q = pservice.getOne(id);
		return q;
	}

	@GetMapping("/getOnePro/{id}")
	public Professional getOnePro(@PathVariable long id) {
		System.out.println(id);
		Professional pro = pservice.getOnePro(id);
		return pro;
	}

	@GetMapping("/LoginProfessional/{email}/{password}")
	public Professional loginProfessional(@RequestParam String email, @RequestParam String password) {
		System.out.println(email);
		System.out.println(password);
		return pservice.loginProfessional(email, password);

	}

	@PostMapping("/updateProfessional")
	public void updateProfessional(@RequestBody Professional pro) {
		pservice.updateProfessional(pro);
	}

	@GetMapping("/getByPincode/pincode")
	public List<Professional> findByPinCode(@RequestParam String pincode) {
		List<Professional> dlist = pservice.findByPincode(pincode);
		return dlist;
	}

	@GetMapping("/validation/value")
	public List<Professional> findByValidation(@RequestParam boolean value) {
		List<Professional> list = pservice.findByValidation(value);
		return list;
	}

	@GetMapping("/UpdateValidation/{id}")
	public void updateValidation(@RequestParam long id) {
		pservice.ValidationUpdation(id);
	}

	@GetMapping("/DeleteMapping/{id}")
	public void DeleteProfessional(@RequestParam long id) {
		pservice.DeleteProfessional(id);
	}

	@GetMapping("/CheckForEmail/{email}")
	public String checkForEmail(@RequestParam String email) {
		String emailAddress = pservice.checkForEmail(email);
		System.out.println(email);
		System.out.println(emailAddress);
		return emailAddress;
	}
}
