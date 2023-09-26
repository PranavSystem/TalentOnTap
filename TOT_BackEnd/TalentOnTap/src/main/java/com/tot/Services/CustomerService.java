package com.tot.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tot.Classes.Customer;
import com.tot.Repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerRepository crepo;

	public Customer findCustomerById(Long id) {
		Customer c = crepo.getById(id);
		return c;
	}

	public List<Customer> getAllCustomer() {
		List<Customer> clist = crepo.findAll();
		return clist;

	}

	public int AddCustomer(Customer c) {

//		String sha256hex = Hashing.sha256()
//				  .hashString(p.getPassword(), StandardCharsets.UTF_8)
//				  .toString();
//		p.setPassword(sha256hex);

		try {
			MessageDigest dutil = MessageDigest.getInstance("SHA-256");
			String sha256hex = DigestUtils.sha256Hex(c.getPassword());
			c.setPassword(sha256hex);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		crepo.save(c);
		System.out.println("Customer Saved");
		return 1;

	}

	public void updateCustomer(Customer p) {
		Customer psave = crepo.getById(p.getCid());

		if (psave.getMiddle() != p.getMiddle())
			psave.setMiddle(p.getMiddle());

		if (psave.getFirst() != p.getFirst())
			psave.setFirst(p.getFirst());
		if (psave.getEmailID() != p.getEmailID())
			psave.setEmailID(p.getEmailID());

		if (psave.getLast() != p.getLast())
			psave.setLast(p.getLast());

		if (psave.getMobileNo() != p.getMobileNo())
			psave.setMobileNo(p.getMobileNo());

		if (psave.getDob() != p.getDob())
			psave.setDob(p.getDob());

		if (psave.getArea() != p.getArea())
			psave.setArea(p.getArea());

		if (psave.getCity() != p.getCity())
			psave.setCity(p.getCity());

		if (psave.getState() != p.getState())
			psave.setState(p.getState());

		if (psave.getCountry() != p.getCountry())
			psave.setCountry(p.getCountry());

		if (psave.getPinCode() != p.getPinCode())
			psave.setPinCode(p.getPinCode());

		System.out.println(p.getMobileNo());

		crepo.save(psave);

	}

	public void deleteCustomer(Long cid) {
		crepo.deleteById(cid);
	}

	public Customer loginCustomer(String email, String password) {
		try {
			MessageDigest dutil = MessageDigest.getInstance("SHA-256");
			String sha256hex = DigestUtils.sha256Hex(password);
			password = sha256hex;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Customer c = crepo.findByemailIDAndPassword(email, password);
		if (c != null) {
			if (c.getEmailID().equals(email) && c.getPassword().equals(password))
				return c;
		}
		return null;

	}

	public String checkForEmail(String email) {
		Customer c = crepo.findByemailID(email);
		if (c != null) {
			if (c.getEmailID().equals(email))
				return c.getEmailID();
		}
		return null;
	}
}
