package com.ycp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ycp.Classes.AdminClass;


@Repository
public interface AdminRepository extends JpaRepository<AdminClass, Integer> {// admin class,primary key type
	public AdminClass findByemailAndPassWord(String email, String password);
}
