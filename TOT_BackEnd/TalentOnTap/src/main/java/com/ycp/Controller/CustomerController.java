package com.ycp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ycp.Classes.Customer;
import com.ycp.Services.CustomerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService cService;

	@GetMapping("/one/{Pid}")
	public Customer findCustomerById(@RequestParam Long Cid) {
		System.out.println(Cid);
		Customer p = cService.findCustomerById(Cid);
		return p;
	}

	@GetMapping("/getAll")
	public List getAllCustomer() {
		System.out.println("Get All called");
		List<Customer> plist = cService.getAllCustomer();

		return plist;
	}

	@PostMapping("/addCustomer")
	public int addPatient(@RequestBody Customer c) {

		System.out.println(c.toString());
		cService.AddCustomer(c);
		return 1;
	}

	@PutMapping("/updateCustomer")
	public void updatePatient(@RequestBody Customer c) {

		cService.updateCustomer(c);

	}

	@DeleteMapping("/deleteCustomer/{Pid}")
	public void deletePatient(@RequestParam Long Cid) {
		cService.deleteCustomer(Cid);
		System.out.println("Customer Deleted Successfully");
	}

	@GetMapping("/customerLogin/{email}/{password}")
	public Customer loginPatient(@RequestParam String email, @RequestParam String password) {
		System.out.println(email + "  " + password);
		Customer c = cService.loginCustomer(email, password);
		return c;
	}

	@GetMapping("/checkForEmail/{email}")
	public String checkForEmail(@RequestParam String email) {
		String emailId = cService.checkForEmail(email);
		return emailId;
	}
}
