package com.tot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tot.Classes.Qualifications;

public interface QualiRepository extends JpaRepository<Qualifications, Integer> {
	public Qualifications findByProPincode(String pincode);

	public Qualifications findByCertificateAndProPincode(String certificate, String pincode);
}
