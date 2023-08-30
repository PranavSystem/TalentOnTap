package com.ycp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ycp.Classes.AdminClass;
import com.ycp.Services.AdminService;

@CrossOrigin(origins = "*")
@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	private AdminService adservie;

	// to get single admin by id
	@GetMapping("/getOneAdmin")
	public AdminClass getAdmin(int id) {
		AdminClass ad = adservie.getAdmin(id);
		return ad;
	}

	// to add single addAdmin
	@PostMapping("/addAdmin")
	public void addAdmin(@RequestBody AdminClass admin) {

		System.out.println(admin.getName());
		System.out.println(admin.getPassWord());
		adservie.addAdmin(admin);
	}

	// to delete single addAdmin by id
	@DeleteMapping("/deleteAdmine")
	public void deletMapping(int id) {
		adservie.deletMapping(id);
	}

	// login as admin
	@GetMapping("/Login/{email}/{password}")
	public AdminClass getAdmin(@RequestParam String email, @RequestParam String password) {
		AdminClass ad = adservie.loginAdmin(email, password);
		System.out.println(ad);
		return ad;
	}
}