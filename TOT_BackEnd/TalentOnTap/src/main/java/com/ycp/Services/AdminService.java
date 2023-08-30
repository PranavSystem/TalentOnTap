package com.ycp.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycp.Classes.AdminClass;
import com.ycp.Repository.AdminRepository;

@Service
@Transactional
public class AdminService {
	@Autowired
	private AdminRepository adminRepo;

	public AdminClass getAdmin(int id) {
		AdminClass ad = adminRepo.findById(id).get();
		return ad;
	}

	public void addAdmin(AdminClass admin) {
		// String sha256hex =null;
		try {

			MessageDigest dutil = MessageDigest.getInstance("SHA-256");
			String sha256hex = DigestUtils.sha256Hex(admin.getPassWord());
			admin.setPassWord(sha256hex);
			// adminRepo.save(admin);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		adminRepo.save(admin);
	}

	public void deletMapping(int id) {
		adminRepo.deleteById(id);
	}

	public AdminClass loginAdmin(String email, String password) {
		String sha256hex = null;
		try {
			MessageDigest dutil = MessageDigest.getInstance("SHA-256");
			sha256hex = DigestUtils.sha256Hex(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdminClass ad = adminRepo.findByemailAndPassWord(email, sha256hex);
		if (ad != null) {
			if (ad.getEmail().equals(email) && ad.getPassWord().equals(sha256hex))
				return ad;
		}

		return null;
	}

}
