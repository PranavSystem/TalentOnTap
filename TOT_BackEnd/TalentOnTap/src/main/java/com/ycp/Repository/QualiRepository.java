package com.ycp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ycp.Classes.Qualifications;

public interface QualiRepository extends JpaRepository<Qualifications, Integer> {
	public Qualifications findByProPincode(String pincode);

	public Qualifications findByCertificateAndProPincode(String certificate, String pincode);
}
